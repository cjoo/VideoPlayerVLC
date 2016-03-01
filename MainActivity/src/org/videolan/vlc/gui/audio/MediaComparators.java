/*****************************************************************************
 * MediaComparators.java
 *****************************************************************************
 * Copyright © 2013 VLC authors and VideoLAN
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
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston MA 02110-1301, USA.
 *****************************************************************************/
package org.videolan.vlc.gui.audio;

import java.util.Comparator;

import org.videolan.libvlc.Media;

public class MediaComparators {

    private static int nullInsensitiveStringCompare(final String s1, final String s2) {
        if (s1 == null ^ s2 == null)
            return s1 == null ? -1 : 1;

        if (s1 == null && s2 == null)
            return 0;

        return String.CASE_INSENSITIVE_ORDER.compare(s1, s2);
    }

    public static final Comparator<Media> byName = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            return nullInsensitiveStringCompare(m1.getTitle(), m2.getTitle());
        };
    };

    public static final Comparator<Media> byMRL = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            return nullInsensitiveStringCompare(m1.getLocation(), m2.getLocation());
        };
    };

    public static final Comparator<Media> byLength = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            if(m1.getLength() > m2.getLength()) return -1;
            if(m1.getLength() < m2.getLength()) return 1;
            else return 0;
        };
    };

    public static final Comparator<Media> byAlbum = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            int res = nullInsensitiveStringCompare(m1.getAlbum(), m2.getAlbum());
            if (res == 0)
                res = byMRL.compare(m1, m2);
            return res;
        };
    };

    public static final Comparator<Media> byArtist = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            int res = nullInsensitiveStringCompare(m1.getReferenceArtist(), m2.getReferenceArtist());
            if (res == 0)
                res = byAlbum.compare(m1, m2);
            return res;
        };
    };

    public static final Comparator<Media> byGenre = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            int res = nullInsensitiveStringCompare(m1.getGenre(), m2.getGenre());
            if (res == 0)
                res = byArtist.compare(m1, m2);
            return res;
        };
    };

    public static final Comparator<Media> byTrackNumber = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            if(m1.getTrackNumber() < m2.getTrackNumber()) return -1;
            if(m1.getTrackNumber() > m2.getTrackNumber()) return 1;
            else return 0;
        }
    };
}
