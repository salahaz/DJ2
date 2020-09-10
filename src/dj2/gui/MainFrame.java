package dj2.gui;

import javax.swing.*;

import dj2.core.Album;
import dj2.core.Artist;
import dj2.core.Concert;
import dj2.core.LinkedList;
import dj2.core.MusicTrack;
import dj2.core.RecentlyPlayed;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame{
	private UserRelatedPane leftPane;
	private Container container;
	private CenterPane centerPane;
	private MenuBar menuBar = new MenuBar(this);
	private static LinkedList<MusicTrack> songs = new LinkedList<MusicTrack>();
	private static LinkedList<Album> albums = new LinkedList<Album>();
	private static LinkedList<Concert> concerts = new LinkedList<Concert>();
	private static LinkedList<Artist> artists = new LinkedList<Artist>();
	public MainFrame () {
		super("DJ2");
		leftPane = new UserRelatedPane(this);
		centerPane = new CenterPane(this, menuBar.getAlbum());
		container= getContentPane();
		setJMenuBar(menuBar);
		setVisible(true);
		setSize(1000,750);
		setResizable(false);
		//pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container.setLayout(new BorderLayout());
		container.add(leftPane, BorderLayout.LINE_START);
		container.add(centerPane, BorderLayout.CENTER);
		
		//centerPane.showPanel();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			} 
		});
		pack();
	}
	
	public CenterPane getCenterPane() {
		return centerPane;
	}
	
	public static void addSong(MusicTrack song) {
		songs.add(song);
		ListPanel.addRow(song.getTitle(), song.getArtist(), song.getReleaseDate());
	}
	
	public static LinkedList<MusicTrack> getSongs() {
		return songs;
	}
	/*public static LinkedList<Album> getAlbums() {
		return albums;
	}*/
	public static void addAlbum(Album album) {
		albums.add(album);
		AlbumsListPanel.addRow(album.getTitle(), album.getArtist(), album.getReleaseDate());
	}
	public static void addConcert(Concert concert) {
		concerts.add(concert);
		ConcertListPanel.addRow(concert.getTitle(), concert.getArtist(), concert.getReleaseDate(), concert.getLocation());
	}
	public static void addArtist(Artist artist) {
		artists.add(artist);
		ArtistsListPanel.addRow(artist.getName());
	}
	public static LinkedList<Album> getAlbums() {
		return albums;
	}
	public UserRelatedPane getUserRelatedPanel() {
		return leftPane;
	}
}
