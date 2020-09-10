package dj2.core;

import dj2.gui.RecentlyPlayedPanel;

/**
 * A recently playedlist, gets created automatically in the music player, which add songs based on the last one played.
 * 
 * @author Salah Eddine Azekour;
 */
public class RecentlyPlayed {
	private static Queue<MusicTrack> recentlyPlayed = new Queue<MusicTrack>();
	/**
	 * it is a static method that takes MusicTrack song and adds it the recently playedlist
	 * @param song song to be added to the recently playedlist
	 */
	public static void addSong(MusicTrack song) {
		if(searchSong(song) == true) 
			recentlyPlayed.delete(song);
		recentlyPlayed.add(song);
		RecentlyPlayedPanel.addRow(song.getTitle(), song.getArtist(), song.getReleaseDate());
	}
	/**
	 * plays the whole songs in the playlist
	 */
	public static void play() {
		recentlyPlayed.playList();
	}
	private static boolean searchSong(MusicTrack song) {
		return (recentlyPlayed.search (song) != null);
	}
	private Queue<MusicTrack> getRecentlyPlayed() {
		return recentlyPlayed;
	}
}