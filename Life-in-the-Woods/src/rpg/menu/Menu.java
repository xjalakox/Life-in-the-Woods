package rpg.menu;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
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



public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JPanel mainpanel;
	private JLabel mainlabel;
	private JLabel start;

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
		setBounds(0, 0, 1120, 840);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		
		mainpanel = new JPanel();
		mainpanel.setSize(1120, 840);
		mainpanel.setVisible(true);
		mainpanel.setLayout(null);
		super.add(mainpanel);
		
		mainlabel = new JLabel(new ImageIcon(getClass().getResource("/resource/homescreen.jpg")));
		mainlabel.doLayout();
		mainlabel.setBounds(0,0,1120,840);
		mainpanel.add(mainlabel);
		
//		start = new JLabel();
//		start.setIcon(new ImageIcon(getClass().getResource("/resource/search_default.png")));
//		start.setBounds(630,500,500,78);
//		start.addMouseListener(new MouseAdapter() {
//									
//					boolean sgHover = false;
//							
//					public void mouseEntered(MouseEvent evt) {
//						start.setIcon(new ImageIcon(getClass().getResource("/resource/search_hover.png")));
//						sgHover = true;
//
//						
//					}
//					public void mouseExited(MouseEvent evt) {
//						start.setIcon(new ImageIcon(getClass().getResource("/resource/search_default.png")));
//						sgHover = false;
//					}
//					public void mousePressed(MouseEvent evt) {
//						start.setIcon(new ImageIcon(getClass().getResource("/resource/search_pressed.png")));
//						Close();
//					}
//					public void mouseReleased(MouseEvent evt) {
//						if (sgHover == true) {
//							start.setIcon(new ImageIcon(getClass().getResource("/resource/search_hover.png")));
//						}
//					}
//		});
//		mainlabel.add(start);
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
