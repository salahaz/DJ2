package dj2.gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MusicTypesPane extends JPanel{
	
	private JList<String> list;
	public MusicTypesPane(MainFrame frame) {
		super();
		setOpaque(true);
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(185, 175));
		list = new JList<String>(new String[] {"Recently Played","Singles","Albums","Concerts", "Artists"});
		list.setFont(new Font("Verdena", Font.BOLD, 12));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFixedCellWidth(185);
		list.setFixedCellHeight(35);
		list.setBackground(Color.WHITE);
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {
				String value = (String) ((JList)ev.getSource()).getSelectedValue();
				int selectedIndex = list.getSelectedIndex();
				if(ev.getClickCount() == 2) {
					if (selectedIndex == 0){
						frame.getCenterPane();
						frame.getCenterPane().c1.show(CenterPane.getContentPane(), "7");	
					} if (selectedIndex == 1) {
						frame.getCenterPane();
						frame.getCenterPane().c1.show(CenterPane.getContentPane(), "2");
					} if (selectedIndex == 2) {
						frame.getCenterPane();
						frame.getCenterPane().c1.show(CenterPane.getContentPane(), "3");
					} if (selectedIndex == 3) {
						frame.getCenterPane();
						frame.getCenterPane().c1.show(CenterPane.getContentPane(), "4");
					} if (selectedIndex == 4) {
						frame.getCenterPane().c1.show(CenterPane.getContentPane(), "6");
					}
				
				}
			}
		});
		add(list);
		
	}
}
