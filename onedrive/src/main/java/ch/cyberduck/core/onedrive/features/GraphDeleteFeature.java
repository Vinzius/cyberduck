package ch.cyberduck.core.onedrive.features;

/*
 * Copyright (c) 2002-2018 iterate GmbH. All rights reserved.
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

import ch.cyberduck.core.DefaultIOExceptionMappingService;
import ch.cyberduck.core.PasswordCallback;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.NotfoundException;
import ch.cyberduck.core.features.Delete;
import ch.cyberduck.core.onedrive.GraphExceptionMappingService;
import ch.cyberduck.core.onedrive.GraphSession;
import ch.cyberduck.core.transfer.TransferStatus;

import org.apache.log4j.Logger;
import org.nuxeo.onedrive.client.Files;
import org.nuxeo.onedrive.client.OneDriveAPIException;
import org.nuxeo.onedrive.client.types.DriveItem;

import java.io.IOException;
import java.util.Map;

public class GraphDeleteFeature implements Delete {
    private static final Logger logger = Logger.getLogger(GraphDeleteFeature.class);

    private final GraphSession session;
    private final GraphFileIdProvider fileid;

    public GraphDeleteFeature(GraphSession session, final GraphFileIdProvider fileid) {
        this.session = session;
        this.fileid = fileid;
    }

    @Override
    public void delete(final Map<Path, TransferStatus> files, final PasswordCallback prompt, final Callback callback) throws BackgroundException {
        for(Path file : files.keySet()) {
            callback.delete(file);
            try {
                final DriveItem item = session.getItem(file);
                Files.delete(item);
                fileid.cache(file, null);
            }
            catch(NotfoundException e) {
                logger.warn(String.format("Cannot delete %s. Not found.", file));
            }
            catch(OneDriveAPIException e) {
                throw new GraphExceptionMappingService(fileid).map("Cannot delete {0}", e, file);
            }
            catch(IOException e) {
                throw new DefaultIOExceptionMappingService().map("Cannot delete {0}", e, file);
            }
        }
    }

    @Override
    public boolean isSupported(final Path file) {
        return session.isAccessible(file, false);
    }

    @Override
    public boolean isRecursive() {
        return true;
    }
}
