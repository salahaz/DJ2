package dj2.core;
/**
 * Contains the majority of music styles
 * @author Salah Eddine Azekour
 *
 */
public enum Style {
	ROCK("ROCK"),
	POP("POP"),
	REGGAE("REGGAE"),
	HOUSE("HOUSE"),
	DANCE("DANCE"),
	RHYTHM_AND_BLUES("R&B"),
	INDIE("Indie"),
	SOUL("Soul"),
	ELECTRONIC("Electronic"),
	ALTERNATIVE("Alternative");
	
	private String value;
	Style(String value) {
		this.value = value;
	}
	/**
	 * Overrides the Object class toString() to display the contents of the enumartion Style
	 * @return {String} The information to be returned back to the user
	 */
	public String toString() {
		return this.value;
	}
}