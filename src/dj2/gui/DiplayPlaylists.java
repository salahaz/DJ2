package dj2.gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dj2.core.MusicTrack;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DiplayPlaylists extends JPanel {

	private static DefaultTableModel model = new DefaultTableModel();
	private static JTable table;
	private static JScrollPane sp;
	private static MusicTrack song;
	private static int row;
	
	public DiplayPlaylists(MainFrame frame) {
		super();
		//this.song = song;
		//this.frame = frame;
		setMinimumSize(new Dimension(815, 618));
		setMaximumSize(new Dimension(815, 618));
		
		model.addColumn("TITLE");
		model.addColumn("ARTISTS");
		model.addColumn("RELEASE DATE");
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		for (int i = 0; i < table.getColumnCount(); i++){
			TableColumn col = table.getColumnModel().getColumn(i);
			col.setPreferredWidth(271);
			col.setMaxWidth(271*5);
		}
		table.setPreferredScrollableViewportSize(new Dimension(815, 618));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setMinimumSize(new Dimension(815, 618));
		table.setMaximumSize(new Dimension(815, 618));
		table.setEnabled(false);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				row = table.rowAtPoint(e.getPoint());
				//song = frame.getSongs().get(row);
				song = (((frame.getUserRelatedPanel()).getPlaylistsPane()).getPlaylist()).get(row);
				UserRelatedPane.setSongInfo(song.getTitle(), song.getArtist());
				song.play();
				return;
			}
		}); 

		sp = new JScrollPane(table);
		add(sp);
	}
	public static void addRow(String title, String artist, String releaseDate) {
		model.addRow(new Object[] {title, artist, releaseDate});
	}

}
