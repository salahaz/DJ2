package dj2.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dj2.core.Album;
import dj2.core.LinkedList;
import dj2.core.MusicTrack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class CenterPane extends JPanel {
	
	private StartUpPanel defaultPanel;
	public static JPanel contentPanel;
	private JPanel controlPanel;
	private JLabel label1, label2, label3;
	private ImageIcon image;
	MusicTrack song;
	public static ListPanel listOfSongs;
	public static AlbumsListPanel listOfAlbums;
	public static ConcertListPanel listOfConcerts;
	ArtistsListPanel artistListPanel;
	RecentlyPlayedPanel recentlyPlayed;
	public static DiplayPlaylists displayPlaylists;
	
	//private static DefaultTableModel model = new DefaultTableModel();
	//private static JTable table;
	//private MainFrame frame;
	public static CardLayout c1 = new CardLayout();
	
	public CenterPane(MainFrame frame, Album album) {
		super();
		listOfSongs = new ListPanel(frame);
		listOfAlbums = new AlbumsListPanel(frame);
		listOfConcerts = new ConcertListPanel(frame);
		artistListPanel = new ArtistsListPanel(frame);
		displayPlaylists = new DiplayPlaylists(frame);
		recentlyPlayed = new RecentlyPlayedPanel(frame);
		
		//this.frame = frame;
		setMinimumSize(new Dimension(815, 750));
		setMaximumSize(new Dimension(815, 750));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		contentPanel = new JPanel();
		controlPanel = new JPanel();
		defaultPanel = new StartUpPanel();
		
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));

		image = new ImageIcon("/Users/salahazekour/Documents/workspace/DJ2/src/dj2/pause.png");
		label2 = new JLabel("", getScaledImage(70,70), JLabel.CENTER);
		label2.setPreferredSize(new Dimension(272, 130));
		
		image = new ImageIcon("/Users/salahazekour/Documents/workspace/DJ2/src/dj2/play.png");
		label1 = new JLabel("", getScaledImage(80,80), JLabel.CENTER);
		label1.setPreferredSize(new Dimension(272, 130));
		
		
		image = new ImageIcon("/Users/salahazekour/Documents/workspace/DJ2/src/dj2/stop.png");
		label3 = new JLabel("", getScaledImage(60,60), JLabel.CENTER);
		label3.setPreferredSize(new Dimension(272, 130));
		
		label1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					song = (frame.getSongs()).get(ListPanel.getRow());
					song.play();
				}
			}
		});
		label2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					song = (frame.getSongs()).get(ListPanel.getRow());
					song.pause();
				}
			}
		});
		label3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					song = (frame.getSongs()).get(ListPanel.getRow());
					song.stop();
					
				}
			}
		});
		
		controlPanel.add(label2);
		controlPanel.add(label1);
		controlPanel.add(label3);
		
		//model.addColumn("TITLE");
		//model.addColumn("ARTISTS");
		//model.addColumn("RELEASE DATE");
		
		//table = new JTable(model);
		//table.setFillsViewportHeight(true);
		
		contentPanel.setLayout(c1);
		
		contentPanel.setMinimumSize(new Dimension(815, 620));
		contentPanel.setMaximumSize(new Dimension(815, 620));
		controlPanel.setMinimumSize(new Dimension(815, 130));
		controlPanel.setMaximumSize(new Dimension(815, 130));
		
		contentPanel.setOpaque(true);
		contentPanel.setBackground(Color.darkGray);
		controlPanel.setOpaque(true);
		controlPanel.setBackground(Color.WHITE);
		
		//if (contentPanel == null)
		contentPanel.add(defaultPanel, "1");
		contentPanel.add(listOfSongs, "2");
		contentPanel.add(listOfAlbums, "3");
		contentPanel.add(listOfConcerts, "4");
		contentPanel.add(displayPlaylists, "5");
		contentPanel.add(artistListPanel, "6");
		contentPanel.add(recentlyPlayed, "7");
		c1.show(contentPanel, "1");
		
		add(contentPanel);
		add(controlPanel);
	}
	
	private ImageIcon getScaledImage(int x, int y){
		BufferedImage resizedImg = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(image.getImage(), 0, 0, x, y, null);
		g2.dispose();

		return (new ImageIcon(resizedImg));
	}
	public static JPanel getContentPane() {
		return contentPanel;
	}
	public static void showPlaylists() {
		c1.show(contentPanel, "5");
	}
	   

}

