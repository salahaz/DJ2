package dj2.core;

import java.util.Arrays;

/**
 * Creates a band with all information related to it, in addition to the band's singles, concerts, and albums
 * 
 * @author Salah Eddine Azekour
 */
public class Band extends Artist {
	private String[] members;
	private int currentIndex;
	/**
	 * The class takes the band's name, and its biography to successfully create a band object
	 * @param name name of the band
	 * @param biography bio/history of the band
	 */
	public Band(String artist, String biography, String[] members) {
		super(artist, biography);
		currentIndex = 0;
		this.members = members;
	}
	/**
	 * Adds the band members
	 * @param singer member of the band
	 */
	public void addMember(String singer) {
		members[currentIndex++] = singer;
	}
	private String displayMembers() {
		return Arrays.toString(members);
	}
	public String toString() {
		return "+  Band\n\t" + "Members: " + displayMembers() + "\n\tBiography: " + biography + "\n\tSingles: " + artistSingles.toString() + "\n\tAlbums: " + artistAlbums.toString() + "\n\tConcerts: "+ artistConcerts.toString() + "\n";
	}
}