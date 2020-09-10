package dj2.core;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dj2.gui.ListPanel;
import javazoom.jl.decoder.JavaLayerException;

/**
 * This class is an abstract
 * , is a class responsible of providing attributes and methods that shared between other types of tracks.
 * @author Salah Eddine Azekour
 */
public abstract class MusicTrack implements Performable {
	protected String musicTitle;
	protected String musicStyle;
	protected String musicType;
	protected Artist artist;
	protected Date musicDuration;
	protected String duration;
	protected String musicPath;
	protected String releaseDate;
	protected PlayPlayer player;
	//private static LinkedList<MusicTrack> Songs = new LinkedList<MusicTrack>();
	/**
	 * Constructer takes song title, duration, style, artist for the song to be created
	 * @param musicTitle the song's title
	 * @param musicDuration the duration of the song
	 * @param musicStyle the song's styles
	 * @param artist the artist of the song
	 * @throws JavaLayerException 
	 * @throws FileNotFoundException 
	 */
	public MusicTrack(String musicTitle, String musicDuration,String musicStyle, Artist artist, String musicPath) throws FileNotFoundException, JavaLayerException {
		this.musicTitle = musicTitle;
		this.musicStyle = musicStyle;
		this.musicPath = musicPath;
		this.artist = artist;
		//new Artist(artist, "");
		duration = musicDuration;
		try {
			player = new PlayPlayer(musicPath);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		//formatDuration(musicDuration);
		//recentSongs = new RecentlyPlayed();
	}
	/**
	 * Plays the current track for the specified duration
	 */
	public void play() {
		/*System.out.println("\""+musicTitle +"\""+", by " + artist.getName() +" is playing now...");
    	try {
    		Thread.sleep(musicDuration.getTime());
    		
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}*/
		try {
			player.play();
		} catch(JavaLayerException e) {
			e.printStackTrace();
		}
    	RecentlyPlayed.addSong(this);
	}
	public void pause() {
		player.pause();
	}
	public void resume() {
		player.resume();
	}
	public void stop() {
		player.stop();
	}
	/**
	 * Overrides the Object class toString() to display the contents of a MusicTrack
	 * @return {String} The information to be returned back to the user
	 */
	public String toString() {
		return ("+  Song\n\tName: " + musicTitle + "\n\tArtist: " + artist.getName() + "\n\tStyle: " + musicStyle + "\n\tDuration: " + duration); // displayDuration()
	}
	/**
	 * Sets the user's String as the value of musicTitle attribute 
	 * @param musicTitle the song's title
	 */
	public void setMusicTitle(String musicTitle){
		this.musicTitle = musicTitle;
		return;
	}
	/**
	 * Sets the user's Style to the attribute musicStyle
	 * @param musicStyle the song's styles
	 */
	public void setMusicStyle(String musicStyle){
		this.musicStyle = musicStyle;
		return;
	}
	/**
	 * Sets the user's Artist of choice to the artist attribute of the object
	 * @param artist the musician of the songs or a band
	 */
	public void setArtist(Artist artist){
		this.artist = artist;
		return;
	}
	/**
	 * Returns musicTitle the MusicTrack's class title to the user
	 */
	public String getTitle(){
		return musicTitle;
	}
	/**
	 * Returns the MusicTrack's type to the user
	 * @return {String} return's the music type
	 */
	public String getType() {
		return musicType;
	}
	public String getArtist() {
		return artist.getName();
	}
	public String getDuration() {
		return duration;
	}
	public abstract String getReleaseDate();
	

	/*private String displayDuration() {
		long seconds = ((long)(musicDuration.getTime() * 0.001));
		long absSeconds = Math.abs(seconds);
		String positive = String.format("%02d:%02d", (absSeconds%3600) / 60, absSeconds%60);
		
		return seconds < 0 ? "-" + positive : positive;
	}
	private void formatDuration(String musicDuration) {
		String durationPattern = "mm:ss";
		SimpleDateFormat formatter = new SimpleDateFormat(durationPattern);
		try {
			this.musicDuration = formatter.parse(musicDuration);
		
		} catch(ParseException e) {
			e.printStackTrace();
		}	
	}*/
}
