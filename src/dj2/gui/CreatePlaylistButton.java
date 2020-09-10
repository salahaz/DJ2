package dj2.gui;

import dj2.core.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class CreatePlaylistButton extends JPanel{

	private PlayList playlist;
	private DefaultListModel<ListEntry> list;
	private JList<ListEntry> newList;
	public CreatePlaylistButton(MainFrame frame) {
		super();
		
		list = new DefaultListModel<ListEntry>();
		list.addElement(new ListEntry("New Playlist", new ImageIcon("/Users/salahazekour/Documents/workspace/DJ2/src/dj2/addButton.png")));
		newList = new JList<ListEntry>(list);
		newList.setCellRenderer(new ListEntryCellRenderer());
		newList.setFont(new Font("Verdena", Font.BOLD, 12));
		newList.setFixedCellWidth(185);
		newList.setFixedCellHeight(55);
		newList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setOpaque(true);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(185, 55));
		add(newList);
		
		newList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				String title = JOptionPane.showInputDialog("Playlist Title");
				playlist = new PlayList(title);
				PlaylistsPane.addPlaylist(playlist);
				PlaylistsPane.addToList(title);
			}
		});
	}

}
