package rpg.menu;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame{
	public Menu(){
	
	setExtendedState(Frame.MAXIMIZED_BOTH);
	setUndecorated(true);
	setVisible(true);
	
	JLabel background = new JLabel(new ImageIcon(getClass().getResource("/resource/homescreen.jpg")));
	background.setBounds(0, 0, getWidth(), getHeight());
	background.setVisible(true);
	add(background);
	setVisible(true);
	}
}
