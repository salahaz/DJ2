package dj2.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;

public class ConcertListPanel extends JPanel {

		private static DefaultTableModel model = new DefaultTableModel();
		private static JTable table;
		private static JScrollPane sp;
		
	public ConcertListPanel(MainFrame frame) {
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
		
		/*table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				row = table.rowAtPoint(e.getPoint());
				//song = frame.getSongs().get(row);
				song = frame.getSongs().get(row);
				UserRelatedPane.setSongInfo(song.getTitle(), song.getArtist());
				song.play();
				return;
			}
		}); */

		sp = new JScrollPane(table);
		add(sp);
		model.addColumn("Location");
		
	}
	public static void addRow(String title, String artist, String releaseDate, String location){
		model.addRow(new Object[] {title, artist, releaseDate, location});
	}

}
