package dj2.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dj2.core.Album;
import dj2.core.LinkedList;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AlbumsListPanel extends JPanel {
	
	private static DefaultTableModel model = new DefaultTableModel();
	private static JTable table;
	private static JScrollPane sp;
	private static int row;	
	public AlbumsListPanel(MainFrame frame) {
		super();
		
		setMinimumSize(new Dimension(815, 618));
		setMaximumSize(new Dimension(815, 618));
		
		model.addColumn("TITLE");
		model.addColumn("ARTIST");
		model.addColumn("RELEASE DATE");
		
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		System.out.println(table.getColumnCount());
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
		

		sp = new JScrollPane(table);
		add(sp);
	}
	public static void addRow(String title, String artist, String releaseDate) {
		if(model.getRowCount() == 0) {
			model.addRow(new Object[] {title, artist, releaseDate});
		} else {
			int duplicateRow = -1;
		
			for(int i = 0; i < table.getRowCount(); i++) {
				if(table.getModel().getValueAt(i, 0).equals(title)) {
					duplicateRow = i;
					break;
				}
				if (duplicateRow == -1)
					model.addRow(new Object[] {title, artist, releaseDate});
				return;
			}
		}
	}	

}
