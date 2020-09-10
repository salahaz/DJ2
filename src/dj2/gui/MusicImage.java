package dj2.gui;

import javax.swing.*;
import java.awt.*;


public class MusicImage extends JPanel{
	
	static ImageIcon image;
	static JLabel label;
	static JLabel musicTitle = new JLabel();
	static JLabel musicArtist = new JLabel();
	public MusicImage(String path) {
		super();
		setLayout(new BorderLayout());
		image = new ImageIcon(path);
		label = new JLabel("", image, JLabel.CENTER);
		add(label, BorderLayout.CENTER);
		setPreferredSize(new Dimension(185, 50));
		
	}
}
