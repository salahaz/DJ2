package dj2.gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dj2.core.MusicTrack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListPanel extends JPanel {
	//private String[]  columnNames = {"TITLE","ARTIST", "RELEASE DATE"};
	private static DefaultTableModel model = new DefaultTableModel();
	private static JTable table;
	private JMenuItem playlist = new JMenuItem("Add to a playlist");
	private JMenuItem play = new JMenuItem("Play");
	private JMenuItem pause = new JMenuItem("Pause");
	private JMenuItem stop = new JMenuItem("Stop");
	//private static MainFrame frame;
	private static JScrollPane sp;
	private static MusicTrack song;
	private static int row;
	private static JPopupMenu popupMenu = new JPopupMenu();
	
	public ListPanel(MainFrame frame) {
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
		
		popupMenu.add(playlist);
		popupMenu.add(play);
		popupMenu.add(pause);
		popupMenu.add(new JPopupMenu.Separator());
		popupMenu.add(stop);
		
		playlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] listOfPlaylists = (String[]) PlaylistsPane.toArray();
				String choices = (String) JOptionPane.showInputDialog((Component) e.getSource(), "Choose a playlist", "Choose Playlist", JOptionPane.QUESTION_MESSAGE, null, listOfPlaylists, listOfPlaylists[0]);
				
			}
		});
		
		
		table.setComponentPopupMenu(popupMenu);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				row = table.rowAtPoint(e.getPoint());
				//song = frame.getSongs().get(row);
				song = frame.getSongs().get(row);
				UserRelatedPane.setSongInfo(song.getTitle(), song.getArtist());
				song.play();
				return;
			}
		}); 
		/*table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e) && !table.isSelectionEmpty() && (list.locationToIndex(e.getPoint()) == list.getSelectedIndex())){
					popupMenu.show(list, e.getX(), e.getY());
				}
			}
		});*/

		sp = new JScrollPane(table);
		add(sp);
	}
	public static void addRow(String title, String artist, String releaseDate) {
		model.addRow(new Object[] {title, artist, releaseDate});
	}
	public static int getRow() {
		return row;
	}

}
