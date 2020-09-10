package dj2.core;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class ListEntry {
	 	private String value;
	   private ImageIcon icon;
	  
	   public ListEntry(String value, ImageIcon icon) {
	      this.value = value;
	      this.icon = icon;
	   }
	  
	   public String getValue() {
	      return value;
	   }
	  
	   public ImageIcon getIcon() {
	      return icon;
	   }
	  
	   public String toString() {
	      return value;
	   }
	   public Image getImage() {
		   return icon.getImage();
	   }
	   public ImageIcon getScaledImage(){
		    BufferedImage resizedImg = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
		    Graphics2D g2 = resizedImg.createGraphics();

		    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		    g2.drawImage(getImage(), 0, 0, 30, 30, null);
		    g2.dispose();

		    return (new ImageIcon(resizedImg));
		}
}
