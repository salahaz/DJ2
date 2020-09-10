package dj2.core;
/**
 * A playlist, that the end user would be able to define and add any type of songs to it, and classify them by different titles
 * @author Salah Eddine Azekour
 *
 */
public class PlayList implements Performable{
	protected LinkedList<MusicTrack> songs;
	protected String title;
	/**
	 * The class takes a title, and creates a playlist
	 * @param title title of the playlist
	 */
	public PlayList(String title) {
		this.title = title;
		songs = new LinkedList<MusicTrack>();
	}
	/**
	 * Adds a song to the playlist
	 * @param song track to be added to the playlist
	 */
	public void addSong(MusicTrack song) {
		songs.add(song);
	}
	/**
	 * Deletes a song from the playlist 
	 * @param song trakc to be deleted from the playlist 
	 */
	public void deleteSong(MusicTrack song){
		songs.delete(song);
	}
	public LinkedList<MusicTrack> getList() {
		return songs;
	}
	/**
	 * plays the whole songs in the playlist
	 */
	public void play() {
		songs.playList();
	}
	/**
	 * Overrides the Object super class's toString(), to display infromation relevant to a playlist
	 * 
	 * @return {String} The information to be returned back to the user
	 */
	public String getTitle() {
		return title;
	}
	public String toString() {
		return ("+  Playlist: "+ title +"\n"+ songs.toString() );
	}
}