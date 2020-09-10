package dj2.gui;


import dj2.core.LinkedList;
import dj2.core.MusicTrack;
import dj2.core.PlayList;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.*;
//import javax.swing.DefaultListMode;


public class PlaylistsPane extends JPanel{
	private static LinkedList<PlayList> listOfPlaylists = new LinkedList<PlayList>();
	private static DefaultListModel<String> listModel = new DefaultListModel<String>();
	private static PlayList playlist;
	private JList list;
	private JScrollPane scrollPane;
	
	public PlaylistsPane(MainFrame frame) {
		super();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		list = new JList(listModel);
		list.setFont(new Font("Verdena", Font.BOLD, 12));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(3);
		list.setFixedCellWidth(185);
		list.setFixedCellHeight(18);
		setPreferredSize(new Dimension(185, 135));
		list.setPreferredSize(new Dimension(185, 135));
		scrollPane = new JScrollPane(new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(185, 135));
		

		
		
		
		add(scrollPane);
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JList theList = (JList) e.getSource();
				if (e.getClickCount() == 2) {
					int index = theList.locationToIndex(e.getPoint());
					playlist = listOfPlaylists.get(index);
					CenterPane.showPlaylists();
					
				}
			}
		});
		
		
		/*list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e) && !list.isSelectionEmpty() && (list.locationToIndex(e.getPoint()) == list.getSelectedIndex())){
					popupMenu.show(list, e.getX(), e.getY());
				}
			}
		});*/
		
	}
	
	public static void addPlaylist(PlayList playlist) {
		listOfPlaylists.add(playlist);
	}
	public static void addToList(String title) {
		listModel.addElement(title);
	}
	public static LinkedList<MusicTrack> getPlaylist() {
		return playlist.getList();
	}
	public static Object[] toArray() {
		return listOfPlaylists.toArray();
	}
}
