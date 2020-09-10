package dj2.core;

/**
 * Creates an artist with all information related to him, in addition to his singles, concerts, and albums
 * 
 * @author Salah Eddine Azekour
 */
public class Artist implements Performable{
	protected String artist;
	protected String biography;
	protected LinkedList<MusicTrack> artistSingles;
	protected LinkedList<Album> artistAlbums;
	protected LinkedList<Concert> artistConcerts;
	protected static LinkedList<Artist> artistList = new LinkedList<Artist>();
	/**
	 * The class takes a name, and biography to successfully create the artist
	 * @param artist name of the artist
	 * @param biography bio/history of the artist
	 */
	public Artist(String artist, String biography) {
		this.artist = artist;
		this.biography = biography;
		artistSingles = new LinkedList<MusicTrack>();
		artistAlbums = new LinkedList<Album>();
		artistConcerts = new LinkedList<Concert>();
	}
	/**
	 * Gives the ability to change the biography of an artist
	 * @param biography artist's biography
	 */
	public void updateBio(String biography){
		this.biography = biography;
	}
	/**
	 * Adds the artists singles
	 * @param single Single track to be added
	 */
	public void addSingle(TrackSingle single) {
		artistSingles.add(single);
	}
	/**
	 * Adds the artists concerts 
	 * @param concert Concert track to be added
	 */
	public void addConcert(Concert concert) {

	}
	/**
	 * Adds the artists albums
	 * @param album Album track to be added
	 */
	public void addAlbum(Album album) {
		artistAlbums.add(album);
	}
	/**
	 * Returns the artist's name back
	 * @return {String} returns the artist's name
	 */
	public String getName() {
		return artist; 
	}
	public String getTitle() {
		return "";
	}
	public void play() {
		return;
	}
	/**
	 * Plays the artist's singles
	 */
	public void playSingles() {
		artistSingles.playList();
	}
	/**
	 * Plays the artist's albums
	 */
	public void playAlbums() {
		artistAlbums.playList();
	}
	/**
	 * Plays the artist's concerts
	 */
	public void playConcerts() {
		artistConcerts.playList();
	}
	public Album searchAlbum(String title) {
		return artistAlbums.searchByTitle(title);
	}
	public MusicTrack searchSingles(String title) {
		return artistSingles.searchByTitle(title);
	}
	public Concert searchConcert(String title) {
		return artistConcerts.searchByTitle(title);
	}
	public static void addArtist(Artist artist) {
		artistList.add(artist);
	}
	/**
	 * Overrides the Object super class's toString(), to display infromation relevant to a linked list
	 *
	 * @return {String} The information to be returned back to the user
	 */
	public String toString() {
		return "+  Artist\n\t" + "Artist Name: " + artist + "\n\tBiography: " + biography + "\n\tSingles: " + artistSingles.toString() + "\n\tAlbums: " + artistAlbums.toString() + "\n\tConcerts: "+ artistConcerts.toString() + "\n";
	}
	
}