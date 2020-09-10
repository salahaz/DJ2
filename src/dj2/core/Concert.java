package dj2.core;

import dj2.gui.AlbumsListPanel;

/**
 * It is concert that contains relevant information of real world concerts, and list songs that are played by the artist at the concert
 * @author Salah Eddine Azekour
 *
 */
public class Concert extends Album {
	private String location;
	/**
	 * The concert class takes a name, title,biography, and release date for the album to successfully created
	 * @param artist artist of the album
	 * @param title  title of the album
	 * @param biography history/bio of the album
	 * @param releaseDate date album got released
	 * @param location location where the concert is going to take place
	 */
	public Concert(Artist artist, String title, String biography, String releaseDate, String location) {
		super(artist, title, biography, releaseDate);
		this.location = location;
	}
	public void updateLocation(String location){
		this.location = location;
	}
	/**
	 * adds a TrackConcert to the album
	 * @param song track passed to the method
	 */
	public void addTrack(TrackConcert song) {
		albumTracks.add(song);
		numberOfTracks++;
	}
	public static void addConcert(Concert concert) {
		AlbumsListPanel.addRow(concert.getTitle(), concert.getArtist(), concert.getReleaseDate());
	}
	public String getLocation(){
		return location;
	}
	/**
	 * Overrides the Object super class's toString(), to display infromation relevant to the album
	 * 
	 * @return {String} The information to be returned back to the user
	 */
	public String toString() {
		//System.out.println(albumTracks);
		return ("+  Concert\n\tConcert Title: " + title +"\n\tBiography: " + biography +"\n\tNumber Of Songs: "+ numberOfTracks + "\n\tLocation: "+location);
	}
}