package rpg.gui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import rpg.MouseInput;

public class Gui {
	public BufferedImage cancel,done,health,inventory,map,market,menu,options,quest,questionmark,rotate = null;
	private List<GuiElement> elements = new ArrayList<GuiElement>();
	
	public Gui(){
	}
	
	public void addGuiElement(GuiElement element) {
		elements.add(element);
	}

	public void render(Graphics g) {
		for(GuiElement element : elements) {
			element.render(g);
		}
	}
	
	public void tick() {
		for(GuiElement element : elements) {
			if(element.getRect().contains(new Point(MouseInput.getX(), MouseInput.getY())) && MouseInput.getButton() == MouseEvent.BUTTON1) {
				element.tick();
			}
		}
	}
}
