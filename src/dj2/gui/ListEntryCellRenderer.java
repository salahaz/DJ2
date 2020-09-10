package dj2.gui;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import dj2.core.ListEntry;


public class ListEntryCellRenderer extends JLabel implements ListCellRenderer{
	
	   public Component getListCellRendererComponent(JList list, Object value,
	                                                 int index, boolean isSelected,
	                                                 boolean cellHasFocus) {
	      ListEntry entry = (ListEntry) value;
	  
	      setText(value.toString());
	      setIcon(entry.getScaledImage());
	   
	      if (isSelected) {
	         setBackground(list.getSelectionBackground());
	         setForeground(list.getSelectionForeground());
	      }
	      else {
	         setBackground(list.getBackground());
	         setForeground(list.getForeground());
	      }
	  
	      setEnabled(list.isEnabled());
	      setFont(list.getFont());
	      setOpaque(true);
	  
	      return this;
	   }
}
