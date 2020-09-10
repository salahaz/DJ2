package dj2.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import dj2.gui.AlbumsListPanel;
import dj2.gui.ListPanel;

/**
 * It is an album that contains relevant information of albums, and list of songs that are part of this album
 * @author Salah Eddine Azekour
 *
 */
public class Album implements Performable {
	protected String title;
	protected String biography;
	protected int numberOfTracks;
	protected Artist artist;
	//protected Calendar releaseDate; 
	protected String releaseDate;
	protected LinkedList<MusicTrack> albumTracks;
	//protected static LinkedList<Album> Albums = new LinkedList<Album>();
	/**
	 * The album class takes a name, title, biography, and release date for the album to successfully created
	 * @param artist artist of the album
	 * @param title  title of the album
	 * @param biography history/bio of the album
	 * @param releaseDate date album got released
	 */
	public Album(Artist artist, String title, String biography, String releaseDate) {
		this.artist = artist;
		this.title = title;
		this.biography = biography;
		this.releaseDate = releaseDate;
		albumTracks = new LinkedList<MusicTrack>();
		
		
		//formatDate(releaseDate);
		numberOfTracks = 0;
	}
	/**
	 * plays the songs in the album
	 */
	public void play() {
		albumTracks.playList();
	}
	/**
	 * Overrides the Object super class's toString(), to display infromation relevant to the album
	 * 
	 * @return {String} The information to be returned back to the user
	 */
	public String toString() {
		StringBuffer info = new StringBuffer();
		info.append("+  Album\n\tAlbum Title: " + title +"\n\tRelease Date: " + releaseDate +"\n\tBiography: " + biography +"\n\tNumber Of Songs: "+ numberOfTracks +"\n"+"----------- Related Songs -----------\n" +albumTracks.toString());
		return info.toString();
	}
	/**
	 * gives the ability to change the title of the album
	 * @param title title of the album
	 */
	public void updateTitle(String title) {
		this.title = title;
	}
	/**
	 * gives the ability to change the biography of the album
	 * @param biography biography of the album
	 */
	public void updateBio(String biography) {
		this.biography = biography;
	}
	/**
	 * gives the ability to change the release date of the album
	 * @param releaseDate release date of the album
	 */
	/*public void updateDate(String releaseDate) {
		formatDate(releaseDate);
	}*/
	/**
	 * adds a TrackAlbum to the album
	 * @param song track passed to the method
	 */
	public void addTrack(TrackAlbum song) {
		albumTracks.add(song);
		numberOfTracks++;
	}
	/*public static void addAlbum(Album album) {
		Albums.add(album);
		AlbumsListPanel.addRow(album.getTitle(), album.getArtist(), album.getReleaseDate());
	}*/
	public String getArtist() {
		return artist.getName();
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public LinkedList<MusicTrack> getAlbumSongs() {
		return albumTracks;
	}
	public Object[] toArray() {
		return albumTracks.toArray();
	}
	/**
	 * returns the title back to the user
	 * @return {String} returns the title 
	 */
	public String getTitle(){
		return title;
	}
	/*private void formatDate(String releaseDate) {
		DateFormat datePattern  =new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		Calendar calendar = Calendar.getInstance();
		try {
			date = datePattern.parse(releaseDate);
			calendar.setTime(date);
		
		} catch(ParseException e) {
			e.printStackTrace();
		}
		this.releaseDate = calendar;
	}
	private String displayDate() {
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		String displayedDate = date.format(releaseDate.getTime());
		
		return displayedDate;
	}*/
}