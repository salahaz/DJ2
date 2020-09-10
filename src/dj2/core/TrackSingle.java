package dj2.core;

import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;

/**
 * It is a single track, this is a subclass of MusicTrack 
 * @author Salah Eddine Azekour
 */
public class TrackSingle extends MusicTrack {
	/**
	 * The class takes the single track's title, duration, style, and artist to successfully be created
	 * @param musicTitle song's title
	 * @param musicDuration duration of the song
	 * @param musicStyle the song's style
	 * @param artist the artist of the song
	 * @throws JavaLayerException 
	 * @throws FileNotFoundException 
	 */
	public TrackSingle(String musicTitle, String musicDuration,String musicStyle, Artist artist, String musicPath) throws FileNotFoundException, JavaLayerException {
		super(musicTitle, musicDuration, musicStyle, artist, musicPath);
		musicType = "SINGLE";
		this.artist.addSingle(this);
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	/**
	 * Overrides the Object super class's toString(), to display infromation relevant to a single track
	 * 
	 * @return {String} The information to be returned back to the user
	 */
	public String toString() {
		return super.toString() + "\n\tType: " + musicType + "\n";
	}
}