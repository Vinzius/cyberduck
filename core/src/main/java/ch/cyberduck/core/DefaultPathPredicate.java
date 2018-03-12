package ch.cyberduck.core;

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
 * Bug fixes, suggestions and comments should be sent to:
 * feedback@cyberduck.ch
 */

import org.apache.commons.lang3.StringUtils;

/**
 * Path predicate that takes the region and version id of the path into account for comparisons.
 */
public class DefaultPathPredicate implements CacheReference<Path> {

    private final String reference;

    public DefaultPathPredicate(final Path file) {
        final Path.Type type = file.isSymbolicLink() ? Path.Type.symboliclink : file.isFile() ? Path.Type.file : Path.Type.directory;
        String qualifier = StringUtils.EMPTY;
        if(StringUtils.isNotBlank(file.attributes().getRegion())) {
            if(new PathContainerService().isContainer(file)) {
                qualifier += file.attributes().getRegion();
            }
        }
        if(file.isFile()) {
            if(StringUtils.isNotBlank(file.attributes().getVersionId())) {
                qualifier += file.attributes().getVersionId();
            }
        }
        final String path = file.getAbsolute();
        reference = "[" + type + "]" + "-" + qualifier + path;
    }

    /**
     * Obtain a string representation of the path that is unique for versioned files.
     *
     * @return The absolute path with version ID and checksum if any.
     */
    @Override
    public String toString() {
        return reference;
    }

    @Override
    public boolean equals(Object o) {
        if(null == o) {
            return false;
        }
        if(o instanceof CacheReference) {
            return this.hashCode() == o.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return reference.hashCode();
    }

    @Override
    public boolean test(final Path test) {
        return this.hashCode() == new DefaultPathPredicate(test).hashCode();
    }
}
