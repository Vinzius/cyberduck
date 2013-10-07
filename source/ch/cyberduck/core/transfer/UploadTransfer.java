package ch.cyberduck.core.transfer;

/*
 * Copyright (c) 2002-2013 David Kocher. All rights reserved.
 * http://cyberduck.ch/
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
 *
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

import ch.cyberduck.core.AttributedList;
import ch.cyberduck.core.Filter;
import ch.cyberduck.core.Local;
import ch.cyberduck.core.LocaleFactory;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.Preferences;
import ch.cyberduck.core.Session;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Attributes;
import ch.cyberduck.core.features.Directory;
import ch.cyberduck.core.features.Find;
import ch.cyberduck.core.features.Symlink;
import ch.cyberduck.core.features.Upload;
import ch.cyberduck.core.filter.UploadRegexFilter;
import ch.cyberduck.core.io.AbstractStreamListener;
import ch.cyberduck.core.io.BandwidthThrottle;
import ch.cyberduck.core.shared.DefaultAttributesFeature;
import ch.cyberduck.core.transfer.normalizer.UploadRootPathsNormalizer;
import ch.cyberduck.core.transfer.symlink.SymlinkResolver;
import ch.cyberduck.core.transfer.symlink.UploadSymlinkResolver;
import ch.cyberduck.core.transfer.upload.CompareFilter;
import ch.cyberduck.core.transfer.upload.OverwriteFilter;
import ch.cyberduck.core.transfer.upload.RenameExistingFilter;
import ch.cyberduck.core.transfer.upload.RenameFilter;
import ch.cyberduck.core.transfer.upload.ResumeFilter;
import ch.cyberduck.core.transfer.upload.SkipFilter;

import org.apache.log4j.Logger;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

/**
 * @version $Id$
 */
public class UploadTransfer extends Transfer {
    private static final Logger log = Logger.getLogger(UploadTransfer.class);

    private Filter<Local> filter = new UploadRegexFilter();

    private Upload writer;

    private Attributes attributes;

    private Find find;

    public UploadTransfer(final Session<?> session, final Path root) {
        this(session, Collections.singletonList(root));
        writer = session.getFeature(Upload.class);
        find = session.getFeature(Find.class);
        attributes = new DefaultAttributesFeature(session);
    }

    public UploadTransfer(final Session<?> session, final List<Path> roots, final Filter<Local> f) {
        super(session, new UploadRootPathsNormalizer().normalize(roots), new BandwidthThrottle(
                Preferences.instance().getFloat("queue.upload.bandwidth.bytes")));
        filter = f;
        writer = session.getFeature(Upload.class);
        find = session.getFeature(Find.class);
        attributes = new DefaultAttributesFeature(session);
    }

    public UploadTransfer(final Session<?> session, final List<Path> roots) {
        super(session, new UploadRootPathsNormalizer().normalize(roots), new BandwidthThrottle(
                Preferences.instance().getFloat("queue.upload.bandwidth.bytes")));
        writer = session.getFeature(Upload.class);
        find = session.getFeature(Find.class);
        attributes = new DefaultAttributesFeature(session);
    }

    public <T> UploadTransfer(final T dict, final Session<?> s) {
        super(dict, s, new BandwidthThrottle(
                Preferences.instance().getFloat("queue.upload.bandwidth.bytes")));
        writer = session.getFeature(Upload.class);
        find = session.getFeature(Find.class);
        attributes = new DefaultAttributesFeature(session);
    }

    @Override
    public Type getType() {
        return Type.upload;
    }

    @Override
    public AttributedList<Path> list(final Path directory, final TransferStatus parent) throws BackgroundException {
        if(log.isDebugEnabled()) {
            log.debug(String.format("List children for %s", directory));
        }
        if(directory.getLocal().attributes().isSymbolicLink()
                && new UploadSymlinkResolver(session.getFeature(Symlink.class), this.getRoots()).resolve(directory)) {
            if(log.isDebugEnabled()) {
                log.debug(String.format("Do not list children for symbolic link %s", directory));
            }
            return AttributedList.emptyList();
        }
        else {
            final AttributedList<Path> list = new AttributedList<Path>();
            for(Local local : directory.getLocal().list().filter(filter)) {
                final Path file = new Path(directory, local);
                if(parent.isExists()) {
                    if(find.find(file)) {
                        file.setAttributes(attributes.getAttributes(file));
                    }
                }
                list.add(file);
            }
            return list;
        }
    }

    @Override
    public TransferPathFilter filter(final TransferAction action) {
        if(log.isDebugEnabled()) {
            log.debug(String.format("Filter transfer with action %s", action.toString()));
        }
        final SymlinkResolver resolver = new UploadSymlinkResolver(session.getFeature(Symlink.class), this.getRoots());
        if(action.equals(TransferAction.ACTION_RESUME)) {
            return new ResumeFilter(resolver, session);
        }
        if(action.equals(TransferAction.ACTION_RENAME)) {
            return new RenameFilter(resolver, session);
        }
        if(action.equals(TransferAction.ACTION_RENAME_EXISTING)) {
            return new RenameExistingFilter(resolver, session);
        }
        if(action.equals(TransferAction.ACTION_SKIP)) {
            return new SkipFilter(resolver, session);
        }
        if(action.equals(TransferAction.ACTION_COMPARISON)) {
            return new CompareFilter(resolver, session);
        }
        return new OverwriteFilter(resolver, session);
    }

    @Override
    public TransferAction action(final boolean resumeRequested, final boolean reloadRequested,
                                 final TransferPrompt prompt) throws BackgroundException {
        if(log.isDebugEnabled()) {
            log.debug(String.format("Find transfer action for Resume=%s,Reload=%s", resumeRequested, reloadRequested));
        }
        final TransferAction action;
        if(resumeRequested) {
            // Force resume
            action = TransferAction.ACTION_RESUME;
        }
        else if(reloadRequested) {
            action = TransferAction.forName(Preferences.instance().getProperty("queue.upload.reload.fileExists"));
        }
        else {
            // Use default
            action = TransferAction.forName(Preferences.instance().getProperty("queue.upload.fileExists"));
        }
        if(action.equals(TransferAction.ACTION_CALLBACK)) {
            for(Path upload : this.getRoots()) {
                if(find.find(upload)) {
                    if(upload.attributes().isDirectory()) {
                        if(this.list(upload, new TransferStatus().exists(true)).isEmpty()) {
                            // Do not prompt for existing empty directories
                            continue;
                        }
                    }
                    // Prompt user to choose a filter
                    return prompt.prompt();
                }
            }
            // No files exist yet therefore it is most straightforward to use the overwrite action
            return TransferAction.ACTION_OVERWRITE;
        }
        return action;
    }

    @Override
    public void transfer(final Path file, final TransferOptions options, final TransferStatus status) throws BackgroundException {
        if(log.isDebugEnabled()) {
            log.debug(String.format("Transfer file %s with options %s", file, options));
        }
        final Symlink symlink = session.getFeature(Symlink.class);
        final SymlinkResolver symlinkResolver = new UploadSymlinkResolver(symlink, this.getRoots());
        if(file.getLocal().attributes().isSymbolicLink() && symlinkResolver.resolve(file)) {
            // Make relative symbolic link
            final String target = symlinkResolver.relativize(file.getLocal().getAbsolute(),
                    file.getLocal().getSymlinkTarget().getAbsolute());
            if(log.isDebugEnabled()) {
                log.debug(String.format("Create symbolic link from %s to %s", file, target));
            }
            symlink.symlink(file, target);
        }
        else if(file.attributes().isFile()) {
            session.message(MessageFormat.format(LocaleFactory.localizedString("Uploading {0}", "Status"),
                    file.getName()));
            // Transfer
            writer.upload(file, bandwidth, new AbstractStreamListener() {
                @Override
                public void bytesSent(long bytes) {
                    addTransferred(bytes);
                }
            }, status);
        }
        else if(file.attributes().isDirectory()) {
            session.message(MessageFormat.format(LocaleFactory.localizedString("Making directory {0}", "Status"),
                    file.getName()));
            if(!status.isExists()) {
                session.getFeature(Directory.class).mkdir(file, null);
            }
        }
    }
}
