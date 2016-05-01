package rpg.gui;

import java.awt.Graphics;

import rpg.Handler;

public class TextDraw {
	
	private static String text = "";
	private static String draw = "";
	private int cur = 0;
	
	public static void drawText(int id) {
		text = Handler.texts.getText(0);
	}
	private int time = 0;
	
	public void render(Graphics g) {
		g.drawString(draw, 1000, 800);
	}
	
	public void tick() {
		time++;
		if(!text.isEmpty() && time % 6 == 0 &&text.length()>cur) {
			System.out.println(cur);
			char c = text.charAt(cur);
			draw += c;
			cur++;
		}
		
	}
}
