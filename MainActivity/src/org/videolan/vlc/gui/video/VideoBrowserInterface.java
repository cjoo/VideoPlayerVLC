/*****************************************************************************
 * VideoBrowserInterface.java
 *****************************************************************************
 * Copyright © 2014-2015 VLC authors and VideoLAN
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

package org.videolan.vlc.gui.video;

import java.util.concurrent.BrokenBarrierException;

import org.videolan.libvlc.Media;

public interface VideoBrowserInterface {
    public static final long HEADER_VIDEO = 0;
	public static final long HEADER_MUSIC = 1;
	public static final long HEADER_CATEGORIES = 2;
	public static final long HEADER_MISC = 3;
	public static final long FILTER_ARTIST = 3;
	public static final long FILTER_GENRE = 4;

	public static final String MEDIA_SECTION = "id";
	public static final String AUDIO_CATEGORY = "category";
	public static final String AUDIO_FILTER = "filter";

	public void resetBarrier();
	public void setItemToUpdate(Media item);
	public void await() throws InterruptedException, BrokenBarrierException;
	public void updateItem();
	public void updateList();
    public void showProgressBar();
    public void hideProgressBar();
    public void clearTextInfo();
    public void sendTextInfo(String info, int progress, int max);
}
