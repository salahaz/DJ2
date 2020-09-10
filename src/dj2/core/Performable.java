package dj2.core;
/**
 * Contains play and get title methods
 * @author Salah Eddine Azekour
 *
 */
public interface Performable {
	/**
	 * Returns the title of an object back
	 * @return {String} the title to be returned
	 */
	String getTitle();
	/**
	 * Plays a song, album, or concert
	 */
	void play();
}
