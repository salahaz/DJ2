package dj2.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

import dj2.core.MusicTrack;

public class UserRelatedPane extends JPanel {
	
	public MusicTypesPane musicTypes; 
	public CreatePlaylistButton newPlaylist;
	public PlaylistsPane playlistPane;
	public static MusicImage musicImage = new MusicImage("/Users/salahazekour/Documents/workspace/DJ2/src/dj2/defaultImage.png");
	//MusicInfoPane musicInfo = new MusicInfoPane("Groupie Love", "Lana Del Ray");
	JLabel playlists = new JLabel("PLAYLISTS");
	JLabel library = new JLabel("YOUR LIBRARY");
	public static JLabel musicTitle = new JLabel("Song Title");
	public static JLabel musicArtist = new JLabel("Song Artist");
	EmptyBorder border = new EmptyBorder(20,0,20,0);
	
	public UserRelatedPane(MainFrame frame) {
		super();
		
		musicTypes = new MusicTypesPane(frame);
		newPlaylist = new CreatePlaylistButton(frame);
		playlistPane = new PlaylistsPane(frame);
		setMinimumSize(new Dimension(185,750));
		setMaximumSize(new Dimension(185,750));
		setOpaque(true);
		setBackground(Color.WHITE);
		//label.setHorizontalAlignment(label.CENTER);
		//label.setHorizontalTextPosition(label.CENTER);
		
		playlists.setOpaque(true);
		playlists.setBackground(Color.WHITE);
		playlists.setMinimumSize(new Dimension(185, 55));
		playlists.setMaximumSize(new Dimension(185, 55));
		playlists.setAlignmentX(Component.CENTER_ALIGNMENT);
		playlists.setBorder(border);
		musicTitle.setOpaque(true);
		musicTitle.setBackground(Color.WHITE);
		musicTitle.setMinimumSize(new Dimension(188, 55));
		musicTitle.setMaximumSize(new Dimension(188, 55));
		musicTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		musicArtist.setBorder(border);
		musicArtist.setOpaque(true);
		musicArtist.setBackground(Color.WHITE);
		musicArtist.setMinimumSize(new Dimension(188, 55));
		musicArtist.setMaximumSize(new Dimension(188, 55));
		musicArtist.setAlignmentX(Component.CENTER_ALIGNMENT);
		musicArtist.setBorder(border);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		library.setOpaque(true);
		library.setBackground(Color.WHITE);
		library.setMinimumSize(new Dimension(185, 55));
		library.setMaximumSize(new Dimension(185, 55));
		library.setAlignmentX(Component.CENTER_ALIGNMENT);
		library.setBorder(border);
		add(library);
		add(musicTypes);
		add(playlists);
		add(playlistPane);
		add(newPlaylist);
		add(musicImage);
		add(musicTitle);
		add(musicArtist);
		
	}
	public static void setSongInfo(String title, String artist) {
		musicTitle.setText(title);
		musicArtist.setText(artist);
	}
	public PlaylistsPane getPlaylistsPane() {
		return playlistPane;
	}
}
