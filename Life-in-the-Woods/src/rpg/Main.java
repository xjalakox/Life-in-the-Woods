package rpg;
import java.awt.Frame;

import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame("RPG");
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.add(game);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		game.start();
	}

}
