package ch.cyberduck.core.b2;

/*
 * Copyright (c) 2002-2016 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.Cache;
import ch.cyberduck.core.ConnectionCallback;
import ch.cyberduck.core.DefaultIOExceptionMappingService;
import ch.cyberduck.core.DisabledListProgressListener;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.PathContainerService;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.AttributesFinder;
import ch.cyberduck.core.features.Find;
import ch.cyberduck.core.features.Write;
import ch.cyberduck.core.http.AbstractHttpWriteFeature;
import ch.cyberduck.core.http.DelayedHttpEntityCallable;
import ch.cyberduck.core.http.HttpResponseOutputStream;
import ch.cyberduck.core.io.Checksum;
import ch.cyberduck.core.io.ChecksumCompute;
import ch.cyberduck.core.io.ChecksumComputeFactory;
import ch.cyberduck.core.io.HashAlgorithm;
import ch.cyberduck.core.preferences.Preferences;
import ch.cyberduck.core.preferences.PreferencesFactory;
import ch.cyberduck.core.shared.DefaultAttributesFinderFeature;
import ch.cyberduck.core.shared.DefaultFindFeature;
import ch.cyberduck.core.transfer.TransferStatus;

import org.apache.http.entity.AbstractHttpEntity;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import synapticloop.b2.exception.B2ApiException;
import synapticloop.b2.response.B2FileInfoResponse;
import synapticloop.b2.response.B2GetUploadPartUrlResponse;
import synapticloop.b2.response.B2GetUploadUrlResponse;
import synapticloop.b2.response.B2UploadPartResponse;
import synapticloop.b2.response.BaseB2Response;

import static ch.cyberduck.core.b2.B2MetadataFeature.X_BZ_INFO_SRC_LAST_MODIFIED_MILLIS;

public class B2WriteFeature extends AbstractHttpWriteFeature<BaseB2Response> implements Write<BaseB2Response> {
    private static final Logger log = Logger.getLogger(B2WriteFeature.class);

    private final PathContainerService containerService
            = new B2PathContainerService();

    private final B2Session session;
    private final Find finder;
    private final AttributesFinder attributes;

    private final ThreadLocal<B2GetUploadUrlResponse> urls
            = new ThreadLocal<B2GetUploadUrlResponse>();

    private final Preferences preferences = PreferencesFactory.get();

    public B2WriteFeature(final B2Session session) {
        this(session, new DefaultFindFeature(session), new DefaultAttributesFinderFeature(session));
    }

    public B2WriteFeature(final B2Session session, final Find finder, final AttributesFinder attributes) {
        super(finder, attributes);
        this.session = session;
        this.finder = finder;
        this.attributes = attributes;
    }

    @Override
    public HttpResponseOutputStream<BaseB2Response> write(final Path file, final TransferStatus status, final ConnectionCallback callback) throws BackgroundException {
        // Submit store call to background thread
        final DelayedHttpEntityCallable<BaseB2Response> command = new DelayedHttpEntityCallable<BaseB2Response>() {
            /**
             * @return The SHA-1 returned by the server for the uploaded object
             */
            @Override
            public BaseB2Response call(final AbstractHttpEntity entity) throws BackgroundException {
                try {
                    final Checksum checksum = status.getChecksum();
                    if(status.isSegment()) {
                        final B2GetUploadPartUrlResponse uploadUrl
                                = session.getClient().getUploadPartUrl(new B2FileidProvider(session).getFileid(file, new DisabledListProgressListener()));
                        return session.getClient().uploadLargeFilePart(uploadUrl, status.getPart(), entity, checksum.hash);
                    }
                    else {
                        final B2GetUploadUrlResponse uploadUrl;
                        if(null == urls.get()) {
                            uploadUrl = session.getClient().getUploadUrl(new B2FileidProvider(session).getFileid(containerService.getContainer(file), new DisabledListProgressListener()));
                            if(log.isDebugEnabled()) {
                                log.debug(String.format("Obtained upload URL %s for file %s", uploadUrl, file));
                            }
                            urls.set(uploadUrl);
                        }
                        else {
                            uploadUrl = urls.get();
                            if(log.isDebugEnabled()) {
                                log.debug(String.format("Use upload URL %s for file %s", uploadUrl, file));
                            }
                        }
                        try {
                            final Map<String, String> fileinfo = new HashMap<>(status.getMetadata());
                            if(null != status.getTimestamp()) {
                                fileinfo.put(X_BZ_INFO_SRC_LAST_MODIFIED_MILLIS, String.valueOf(status.getTimestamp()));
                            }
                            return session.getClient().uploadFile(uploadUrl,
                                    containerService.getKey(file),
                                    entity, Checksum.NONE == checksum ? "do_not_verify" : checksum.hash,
                                    status.getMime(),
                                    fileinfo);
                        }
                        catch(B2ApiException e) {
                            urls.remove();
                            throw e;
                        }
                    }
                }
                catch(B2ApiException e) {
                    throw new B2ExceptionMappingService().map("Upload {0} failed", e, file);
                }
                catch(IOException e) {
                    throw new DefaultIOExceptionMappingService().map("Upload {0} failed", e, file);
                }
            }

            @Override
            public long getContentLength() {
                return status.getLength();
            }
        };
        return this.write(file, status, command);
    }

    @Override
    public boolean temporary() {
        return false;
    }

    @Override
    public boolean random() {
        return false;
    }

    @Override
    public ChecksumCompute checksum(final Path file) {
        return ChecksumComputeFactory.get(HashAlgorithm.sha1);
    }

    @Override
    public Append append(final Path file, final Long length, final Cache<Path> cache) throws BackgroundException {
        if(length >= preferences.getLong("b2.upload.largeobject.threshold")) {
            if(preferences.getBoolean("b2.upload.largeobject")) {
                final B2LargeUploadPartService partService = new B2LargeUploadPartService(session);
                final List<B2FileInfoResponse> upload = partService.find(file);
                if(!upload.isEmpty()) {
                    Long size = 0L;
                    for(B2UploadPartResponse completed : partService.list(upload.iterator().next().getFileId())) {
                        size += completed.getContentLength();
                    }
                    return new Append(size);
                }
            }
        }
        if(finder.withCache(cache).find(file)) {
            final PathAttributes attributes = this.attributes.withCache(cache).find(file);
            return new Append(false, true).withSize(attributes.getSize()).withChecksum(attributes.getChecksum());
        }
        return Write.notfound;
    }
}
