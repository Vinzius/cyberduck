package ch.cyberduck.core.box;

/*
 * Copyright (c) 2002-2020 iterate GmbH. All rights reserved.
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

import ch.cyberduck.core.BytecountStreamListener;
import ch.cyberduck.core.ConnectionCallback;
import ch.cyberduck.core.Local;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.box.io.swagger.client.model.Files;
import ch.cyberduck.core.box.io.swagger.client.model.UploadSession;
import ch.cyberduck.core.box.io.swagger.client.model.UploadedPart;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.ConnectionCanceledException;
import ch.cyberduck.core.features.Upload;
import ch.cyberduck.core.features.Write;
import ch.cyberduck.core.http.HttpUploadFeature;
import ch.cyberduck.core.io.BandwidthThrottle;
import ch.cyberduck.core.io.StreamListener;
import ch.cyberduck.core.preferences.HostPreferences;
import ch.cyberduck.core.threading.BackgroundExceptionCallable;
import ch.cyberduck.core.threading.ThreadPool;
import ch.cyberduck.core.threading.ThreadPoolFactory;
import ch.cyberduck.core.transfer.SegmentRetryCallable;
import ch.cyberduck.core.transfer.TransferStatus;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class BoxLargeUploadService extends HttpUploadFeature<BoxUploadHelper.BoxUploadResponse, MessageDigest> {
    private static final Logger log = Logger.getLogger(BoxLargeUploadService.class);

    public static final String UPLOAD_SESSION_ID = "uploadSessionId";
    public static final String OVERALL_LENGTH = "overall-length";

    private final BoxSession session;
    private final Integer concurrency;
    private final BoxFileidProvider fileid;

    private Write<BoxUploadHelper.BoxUploadResponse> writer;

    public BoxLargeUploadService(final BoxSession session, final BoxFileidProvider fileid, final Write<BoxUploadHelper.BoxUploadResponse> writer) {
        this(session, fileid, writer,
                new HostPreferences(session.getHost()).getInteger("box.upload.multipart.concurrency"));
    }

    public BoxLargeUploadService(final BoxSession session, final BoxFileidProvider fileid, final Write<BoxUploadHelper.BoxUploadResponse> writer, final Integer concurrency) {
        super(writer);
        this.session = session;
        this.writer = writer;
        this.concurrency = concurrency;
        this.fileid = fileid;
    }

    @Override
    public BoxUploadHelper.BoxUploadResponse upload(final Path file, final Local local, final BandwidthThrottle throttle, final StreamListener listener,
                                                    final TransferStatus status, final ConnectionCallback callback) throws BackgroundException {
        final ThreadPool pool = ThreadPoolFactory.get("multipart", concurrency);
        try {
            final List<Future<BoxUploadHelper.BoxPartUploadResponse>> parts = new ArrayList<>();
            long offset = 0;
            long remaining = status.getLength();
            final BoxUploadHelper helper = new BoxUploadHelper(session, fileid);
            final UploadSession uploadSession = helper.createUploadSession(status, file);
            for(int partNumber = 1; remaining > 0; partNumber++) {
                final long length = Math.min(uploadSession.getPartSize(), remaining);
                parts.add(this.submit(pool, file, local, throttle, listener, status,
                        uploadSession.getId(), partNumber, offset, length, callback));
                remaining -= length;
                offset += length;
            }
            // Checksums for uploaded segments
            final List<BoxUploadHelper.BoxPartUploadResponse> chunks = new ArrayList<>();
            for(Future<BoxUploadHelper.BoxPartUploadResponse> uploadResponseFuture : parts) {
                try {
                    chunks.add(uploadResponseFuture.get());
                }
                catch(InterruptedException e) {
                    log.error("Part upload failed with interrupt failure");
                    status.setCanceled();
                    throw new ConnectionCanceledException(e);
                }
                catch(ExecutionException e) {
                    log.warn(String.format("Part upload failed with execution failure %s", e.getMessage()));
                    if(e.getCause() instanceof BackgroundException) {
                        throw (BackgroundException) e.getCause();
                    }
                    throw new BackgroundException(e.getCause());
                }
            }
            final Files files = helper.commitUploadSession(file, uploadSession.getId(), status,
                    chunks.stream().map(BoxUploadHelper.BoxPartUploadResponse::getPart).map(UploadedPart::getPart).collect(Collectors.toList()));
            status.setComplete();
            return new BoxUploadHelper.BoxUploadResponse(files);
        }
        finally {
            // Cancel future tasks
            pool.shutdown(false);
        }
    }

    private Future<BoxUploadHelper.BoxPartUploadResponse> submit(final ThreadPool pool, final Path file, final Local local,
                                                                 final BandwidthThrottle throttle, final StreamListener listener,
                                                                 final TransferStatus overall, final String uploadSessionId, final int partNumber, final long offset, final long length, final ConnectionCallback callback) {
        if(log.isInfoEnabled()) {
            log.info(String.format("Submit %s to queue with offset %d and length %d", file, offset, length));
        }
        final BytecountStreamListener counter = new BytecountStreamListener(listener);
        return pool.execute(new SegmentRetryCallable<>(session.getHost(), new BackgroundExceptionCallable<BoxUploadHelper.BoxPartUploadResponse>() {
            @Override
            public BoxUploadHelper.BoxPartUploadResponse call() throws BackgroundException {
                overall.validate();
                final TransferStatus status = new TransferStatus()
                        .segment(true)
                        .withOffset(offset)
                        .withLength(length);
                status.setPart(partNumber);
                status.setHeader(overall.getHeader());
                status.setChecksum(writer.checksum(file, status).compute(local.getInputStream(), status));
                final Map<String, String> parameters = new HashMap<>();
                parameters.put(UPLOAD_SESSION_ID, uploadSessionId);
                parameters.put(OVERALL_LENGTH, String.valueOf(overall.getLength()));
                status.withParameters(parameters);
                final BoxUploadHelper.BoxPartUploadResponse response = (BoxUploadHelper.BoxPartUploadResponse) BoxLargeUploadService.this.upload(
                        file, local, throttle, listener, status, overall, status, callback);
                if(log.isInfoEnabled()) {
                    log.info(String.format("Received response %s for part %d", response, partNumber));
                }
                return response;
            }
        }, overall, counter));
    }

    @Override
    public Upload<BoxUploadHelper.BoxUploadResponse> withWriter(final Write<BoxUploadHelper.BoxUploadResponse> writer) {
        this.writer = writer;
        return super.withWriter(writer);
    }
}
