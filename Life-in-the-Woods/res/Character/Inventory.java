package rpg;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Inventory {
	public static JLabel inv;
	public Inventory(){
		Image inv_bg = new ImageIcon(this.getClass().getResource("/Inventory/inv_bg.png")).getImage();;
		inv = new JLabel(new ImageIcon(inv_bg));
		inv.setVisible(false);
		inv.setBounds(0,0,700,900);
	}
}
