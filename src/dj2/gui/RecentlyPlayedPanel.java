package dj2.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dj2.core.MusicTrack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RecentlyPlayedPanel extends JPanel{
	private static DefaultTableModel model = new DefaultTableModel();
	private static JTable table;
	private JMenuItem playlist = new JMenuItem("Add to a playlist");
	private JMenuItem play = new JMenuItem("Play");
	private JMenuItem pause = new JMenuItem("Pause");
	private JMenuItem stop = new JMenuItem("Stop");
	//private static MainFrame frame;
	private JScrollPane sp;
	private static MusicTrack song;
	static int row;
	private JPopupMenu popupMenu = new JPopupMenu();
	
	public RecentlyPlayedPanel(MainFrame frame) {
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
		if(model.getRowCount() == 0) {
			model.insertRow(0,new Object[] {title, artist, releaseDate});
		} else {
			int duplicateRow = -1;
			
			for(int i = 0; i < table.getRowCount(); i++) {
				if(table.getModel().getValueAt(i, 0).equals(title)) {
					duplicateRow = i;
					break;
				}
				if (duplicateRow == -1)
					model.insertRow(0,new Object[] {title, artist, releaseDate});
				return;
			}
		}
	}
	public static int getRow() {
		return row;
	}
}
