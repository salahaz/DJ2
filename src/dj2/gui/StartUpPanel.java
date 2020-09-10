package dj2.gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import dj2.core.PlayList;
import javazoom.jl.decoder.JavaLayerException;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class StartUpPanel extends JPanel{
	
	private JLabel label; 
	private JLabel label2;
	private ImageIcon image;
	private JPanel Innerpanel;
	private String musicPath;
	
	public StartUpPanel() {
		super();
		setMinimumSize(new Dimension(815, 750));
		setMaximumSize(new Dimension(815, 750));
		setOpaque(true);
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		image = new ImageIcon("/Users/salahazekour/Documents/workspace/DJ2/src/dj2/notFound.png");
		label = new JLabel("", image, JLabel.CENTER);
		label.setToolTipText("Double Click, to add a song");
		label.setMaximumSize(new Dimension(100,70));
		label.setMinimumSize(new Dimension(100,70));
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				try {
					MenuBar.chooseFile();
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		/*label2 = new JLabel("Double Click, to add a song", JLabel.CENTER);
		label2.setFont(new Font("helvetica", Font.BOLD, 18));
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		label2.setHorizontalTextPosition(JLabel.CENTER);
		label2.setVerticalTextPosition(JLabel.CENTER);
		label2.setMaximumSize(new Dimension(50,50));
		label2.setMinimumSize(new Dimension(50,50));*/
		
		GridLayout gridLayout = new GridLayout(0,1); 
		GridBagConstraints c = new GridBagConstraints();
		
		Innerpanel = new JPanel();
		Innerpanel.setMinimumSize(new Dimension(815, 750));
		Innerpanel.setMaximumSize(new Dimension(815, 750));
		Innerpanel.setLayout(gridLayout);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		Innerpanel.add(label);
		
		/*c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		Innerpanel.add(label2);*/
		
		add(Innerpanel, BorderLayout.CENTER);	
	}
	/*private ImageIcon getScaledImage(){
		BufferedImage resizedImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(image.getImage(), 0, 0, 100, 100, null);
		g2.dispose();

		return (new ImageIcon(resizedImg));
		}*/
}
