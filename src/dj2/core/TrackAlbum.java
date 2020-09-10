package dj2.core;

import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;

/**
 * It is a album track, this is a subclass of MusicTrack
 * @author Salah Eddine Azekour
 *
 */
public class TrackAlbum extends MusicTrack {
	public Album associatedAlbum;
	/**
	 *  The class takes the album track's title, duration, style, concert it is a part of, and artist to successfully be created
	 * @param musicTitle the song's title
	 * @param musicDuration the duration of the song
	 * @param musicStyle the song's styles
	 * @param associatedAlbum the related album to the song
	 * @param artist the artist of the song
	 * @throws JavaLayerException 
	 * @throws FileNotFoundException 
	 */
	public TrackAlbum (String musicTitle, String musicDuration, String musicStyle, Album associatedAlbum, Artist artist, String releaseDate, String musicPath) throws FileNotFoundException, JavaLayerException {
		super(musicTitle, musicDuration, musicStyle, artist, musicPath);
		this.releaseDate = releaseDate;
		this.associatedAlbum = associatedAlbum;
		/*if (this.artist.searchAlbum(associatedAlbum) == null) {
			this.associatedAlbum = new Album(this.artist, associatedAlbum, "", releaseDate);
			
		} else {
			this.associatedAlbum = this.artist.searchAlbum(associatedAlbum);	
		}*/
		//this.associatedAlbum.addTrack(this);
		musicType = "ALBUM";
		this.artist.addAlbum(this.associatedAlbum);
		//this.associatedAlbum.addTrack(this);
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	/**
	 * Overrides the Object super class's toString(), to display infromation relevant to a album track
	 * 
	 * @return {String} The information to be returned back to the user
	 */
	public String toString() {
		return super.toString() + "\n\tType: " + musicType + "\n\tAssociated Album: " + associatedAlbum.getTitle() + "\n";
	}
}