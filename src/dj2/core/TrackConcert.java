package dj2.core;

import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;

/**
 * It is a concert track, this is a subclass of MusicTrack
 * @author Salah Eddine Azekour
 *
 */
public class TrackConcert extends MusicTrack {
	Concert associatedConcert;
	/**
	 * The class takes the concert track's title, duration, style, concert it is a part of, and artist to successfully be created
	 * @param musicTitle the song's title
	 * @param musicDuration the duration of the song
	 * @param musicStyle the song's styles
	 * @param associatedConcert the related concert to the  song
	 * @param artist the artist of the song
	 * @throws JavaLayerException 
	 * @throws FileNotFoundException 
	 */
	public TrackConcert(String musicTitle, String musicDuration,String musicStyle, Concert associatedConcert, Artist artist,  String releaseDate, String musicPath) throws FileNotFoundException, JavaLayerException {
		super(musicTitle, musicDuration, musicStyle, artist, musicPath);
		/*if (this.artist.searchConcert(associatedConcert) != null) {
			this.associatedConcert = this.artist.searchConcert(associatedConcert);
		} else 
			this.associatedConcert = new Concert(this.artist, associatedConcert, "", "", "");	*/
		this.associatedConcert = associatedConcert;
		this.associatedConcert.addTrack(this);
		musicType = "CONCERT";
		this.artist.addConcert(this.associatedConcert);
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	/**
	 * Overrides the Object super class's toString(), to display infromation relevant to a concert track
	 * 
	 * @return {String} The information to be returned back to the user
	 */
	public String toString() {
		return super.toString() + "\n\tType: " + musicType + "\n\tAssociated Concert: " + associatedConcert.getTitle() + "\n";
	}
}