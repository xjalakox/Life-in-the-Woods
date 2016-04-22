package rpg;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import rpg.Main;



public class Loadingscreen extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel mainpanel;
	private JLabel mainlabel;
	private JLabel start;
	private JLabel close;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loadingscreen frame = new Loadingscreen();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Loadingscreen() {
		

		
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setVisible(true);
		requestFocus();
		
		
		
		mainpanel = new JPanel();
		mainpanel.setSize(getWidth(),getHeight());
		mainpanel.setVisible(true);
		mainpanel.setLayout(null);
		super.add(mainpanel);
		
		Image image1 = new ImageIcon(this.getClass().getResource("/Menu/homescreen.jpg")).getImage();
		Image image2 = new ImageIcon(this.getClass().getResource("/Menu/start_default.png")).getImage();
		Image image3 = new ImageIcon(this.getClass().getResource("/Menu/close_hover.png")).getImage();
		Image image4 = new ImageIcon(this.getClass().getResource("/Menu/start_pressed.png")).getImage();
		Image image5 = new ImageIcon(this.getClass().getResource("/Menu/start_hover.png")).getImage();
		Image image6 = new ImageIcon(this.getClass().getResource("/Menu/close_pressed.png")).getImage();
		Image image7 = new ImageIcon(this.getClass().getResource("/Menu/close_default.png")).getImage();
		
		
		mainlabel = new JLabel(new ImageIcon(image1));
		mainlabel.doLayout();
		mainlabel.setBounds(0,0,getWidth(),getHeight());
		mainpanel.add(mainlabel);
		
		
	}

	public void Close(){
		super.dispose();
	}
}