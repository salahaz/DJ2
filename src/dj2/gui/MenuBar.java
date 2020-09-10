package dj2.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import dj2.core.*;
import javazoom.jl.decoder.JavaLayerException;

public class MenuBar extends JMenuBar{
	
	private JMenu menu1;
	private JMenuItem menuItem1;
	private static String musicPath;
	private static MusicTrack song;
	private static Album album;
	private static Concert concert;
	private static Artist artist;
	
	public MenuBar(MainFrame frame) {
		super();
		menu1 = new JMenu("File");
		menuItem1 = new JMenuItem("Import Song");
		menu1.add(menuItem1);
		add(menu1);
		
		menuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						chooseFile();
					} catch (JavaLayerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		});
	}
	public static void chooseFile() throws JavaLayerException {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 & WAV & AIFF & WMA", "MP3", "WAV", "AIFF", "WMA");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(new JDialog());
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			musicPath = chooser.getSelectedFile().getPath();
			extractData();
			// Defferiate between adding single, albums & concerts
			MainFrame.addSong(song);
			MainFrame.addAlbum(album);
			MainFrame.addArtist(artist);
		}
	}
	private static void extractData() throws JavaLayerException {
		try {
			
			InputStream input = new FileInputStream(new File(musicPath));
			ContentHandler handler = new DefaultHandler();
			Metadata metadata = new Metadata();
			Parser parser = new Mp3Parser();
			ParseContext parseCtx = new ParseContext();
			parser.parse(input, handler, metadata, parseCtx);
			input.close();
			
			artist = new Artist(metadata.get("xmpDM:artist"), "");
			song = new TrackAlbum(metadata.get("title"), metadata.get("xmpDM:duration"),metadata.get("xmpDM:genre"), album, artist, metadata.get("xmpDM:releaseDate"), musicPath);
			album = new Album(artist, metadata.get("xmpDM:album"), "", metadata.get("xmpDM:releaseDate"));
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		} 
	}
	public static MusicTrack getSong() {
		return song;
	}
	public static Artist getArtist() {
		return artist;
	}
	public static Album getAlbum() {
		return album;
	}
	
}
