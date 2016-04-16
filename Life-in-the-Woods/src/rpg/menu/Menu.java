package rpg.menu;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rpg.Game;
import rpg.Main;



public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JPanel mainpanel;
	private JLabel mainlabel;
	private JLabel start;
	private JLabel close;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		

		//CustomCursor();
		
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setVisible(true);
		
		mainpanel = new JPanel();
		mainpanel.setSize(getWidth(),getHeight());
		mainpanel.setVisible(true);
		mainpanel.setLayout(null);
		super.add(mainpanel);
		
		mainlabel = new JLabel(new ImageIcon(getClass().getResource("/resource/homescreen.jpg")));
		mainlabel.doLayout();
		mainlabel.setBounds(0,0,getWidth(),getHeight());
		mainpanel.add(mainlabel);
		
		start = new JLabel();
		start.setIcon(new ImageIcon(getClass().getResource("/resource/start_default.png")));
		start.setBounds(735,500,500,191);
		start.addMouseListener(new MouseAdapter() {
									
					boolean sgHover = false;
							
					public void mouseEntered(MouseEvent evt) {
						start.setIcon(new ImageIcon(getClass().getResource("/resource/start_hover.png")));
						sgHover = true;
					}
					public void mouseExited(MouseEvent evt) {
						start.setIcon(new ImageIcon(getClass().getResource("/resource/start_default.png")));
						sgHover = false;
					}
					public void mousePressed(MouseEvent evt) {
						start.setIcon(new ImageIcon(getClass().getResource("/resource/start_pressed.png")));
						Close();
						Game game = new Game();
						JFrame frame = new JFrame("RPG");
						frame.add(game);
						frame.pack();
						frame.setResizable(false);
						frame.setLocationRelativeTo(null);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);

						game.start();
					}
					public void mouseReleased(MouseEvent evt) {
						if (sgHover == true) {
						start.setIcon(new ImageIcon(getClass().getResource("/resource/start_hover.png")));
					}
				}
		});
		mainlabel.add(start);
		
		close = new JLabel();
		close.setIcon(new ImageIcon(getClass().getResource("/resource/close_default.png")));
		close.setBounds(1830,15,69,69);
		close.addMouseListener(new MouseAdapter() {
									
					boolean sgHover = false;
							
					public void mouseEntered(MouseEvent evt) {
						close.setIcon(new ImageIcon(getClass().getResource("/resource/close_hover.png")));
						sgHover = true;
					}
					public void mouseExited(MouseEvent evt) {
						close.setIcon(new ImageIcon(getClass().getResource("/resource/close_default.png")));
						sgHover = false;
					}
					public void mousePressed(MouseEvent evt) {
						close.setIcon(new ImageIcon(getClass().getResource("/resource/close_pressed.png")));
						Close();
					}
					public void mouseReleased(MouseEvent evt) {
						if (sgHover == true) {
						close.setIcon(new ImageIcon(getClass().getResource("/resource/close_hover.png")));
					}
				}
		});
		mainlabel.add(close);
	}

	public void Close(){
		super.dispose();
	}
	
//	public void CustomCursor(){
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		Image img = toolkit.getImage("cursor.png");
//		Point point = new Point(0,0);
//		Cursor cursor = toolkit.createCustomCursor(img, point, "Cursor");
//		
//		setCursor(cursor);
//	}
}
