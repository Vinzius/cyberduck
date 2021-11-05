package ch.cyberduck.core.eue;

/*
 * Copyright (c) 2002-2021 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.ListProgressListener;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.eue.io.swagger.client.ApiException;
import ch.cyberduck.core.eue.io.swagger.client.api.ListResourceAliasApi;
import ch.cyberduck.core.eue.io.swagger.client.api.ListResourceApi;
import ch.cyberduck.core.eue.io.swagger.client.model.SharePermission;
import ch.cyberduck.core.eue.io.swagger.client.model.UiFsModel;
import ch.cyberduck.core.eue.io.swagger.client.model.UiShareModel;
import ch.cyberduck.core.eue.io.swagger.client.model.UiWin32;
import ch.cyberduck.core.eue.io.swagger.client.model.Uifs;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.AttributesFinder;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EueAttributesFinderFeature implements AttributesFinder {
    private static final Logger log = Logger.getLogger(EueAttributesFinderFeature.class);

    private final EueSession session;
    private final EueResourceIdProvider fileid;

    public EueAttributesFinderFeature(final EueSession session, final EueResourceIdProvider fileid) {
        this.session = session;
        this.fileid = fileid;
    }

    @Override
    public PathAttributes find(final Path file, final ListProgressListener listener) throws BackgroundException {
        if(file.isRoot()) {
            return PathAttributes.EMPTY;
        }
        try {
            final EueApiClient client = new EueApiClient(session);
            final UiFsModel response;
            final String resourceId = fileid.getFileId(file, listener);
            List<String> options = ListOptions.getForWin32AndShares();

            switch(resourceId) {
                case EueResourceIdProvider.ROOT:
                case EueResourceIdProvider.TRASH:
                    response = new ListResourceAliasApi(client).resourceAliasAliasGet(resourceId,
                        null, file.attributes().getETag(), null, null, null, null, options, null);
                    break;
                default:
                    response = new ListResourceApi(client).resourceResourceIdGet(resourceId,
                        null, file.attributes().getETag(), null, null, null, null, options, null);
                    break;
            }
            final PathAttributes attr = this.toAttributes(response.getUifs(), response.getUiwin32(), response.getUishare());
            if(client.getResponseHeaders().containsKey(HttpHeaders.ETAG)) {
                attr.setETag(StringUtils.remove(client.getResponseHeaders().get(HttpHeaders.ETAG).stream().findFirst().orElse(null), '"'));
            }
            return attr;
        }
        catch(ApiException e) {
            switch(e.getCode()) {
                case HttpStatus.SC_NOT_MODIFIED:
                    if(log.isDebugEnabled()) {
                        log.debug(String.format("No changes for file %s with ETag %s", file, file.attributes().getETag()));
                    }
                    return file.attributes();
            }
            throw new EueExceptionMappingService().map("Failure to read attributes of {0}", e, file);
        }
    }

    protected PathAttributes toAttributes(final Uifs entity, final UiWin32 uiwin32, final UiShareModel uiShareModel) {
        final PathAttributes attr = new PathAttributes();
        attr.setDisplayname(entity.getName());
        // Matches ETag response header
        attr.setETag(StringUtils.remove(entity.getMetaETag(), '"'));
        attr.setSize(entity.getSize());
        attr.setFileId(EueResourceIdProvider.getResourceIdFromResourceUri(entity.getResourceURI()));
        if(null == uiwin32) {
            log.warn("Missing extended properties");
            return attr;
        }
        else {
            attr.setCreationDate(uiwin32.getCreationMillis());
            attr.setModificationDate(uiwin32.getLastModificationMillis());
            attr.setAccessedDate(uiwin32.getLastAccessMillis());
            attr.setHidden(uiwin32.isHidden());
        }
        if(null != uiShareModel) {
            final Map<String, String> attrCustom = new HashMap<>();
            uiShareModel.getShare().forEach(share -> {
                final String expirationMillis = String.join(":", "ExpirationMillis", String.valueOf(share.getExpirationMillis()));
                final String ownerName = String.join(":", "OwnerName", share.getOwnerName());
                final String hasPin = String.join(":", "hasPin", String.valueOf(share.isHasPin()));
                final SharePermission resourcePermission = share.getResourcePermission();
                final String readable = String.join(":", "readable", String.valueOf(resourcePermission.isReadable()));
                final String writable = String.join(":", "writable", String.valueOf(resourcePermission.isWritable()));
                final String deletable = String.join(":", "deletable", String.valueOf(resourcePermission.isDeletable()));
                final String shareModel = String.join(",", expirationMillis, ownerName, hasPin, readable, writable, deletable);
                attrCustom.put(share.getName(), shareModel);
            });
            attr.setCustom(attrCustom);
        }
        return attr;
    }
}
