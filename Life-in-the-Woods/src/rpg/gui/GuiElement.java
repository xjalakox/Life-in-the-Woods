package rpg.gui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class GuiElement {
	private Rectangle rect;
	private BufferedImage image;
	private GuiAction action;
	
	public GuiElement(int x, int y, BufferedImage image, GuiAction action) {
		this.image = image;
		this.action = action;
		rect = new Rectangle(x, y, image.getWidth(), image.getHeight());
	}
	
	public void render(Graphics g) {
		g.drawImage(image, (int)rect.getX(),(int) rect.getY(), null);
	}
	
	public void tick() {
		action.action();
	}
	
	public Rectangle getRect() {
		return rect;
	}
}
