package rpg.entity;

import java.awt.Graphics;

import rpg.Game;
import rpg.Handler;
import rpg.Id;

public class player extends Entity {

	public player(int x, int y, int w, int h, Id id, Handler handler) {
		super(x, y, w, h, id, handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		if(facing==1)g.drawImage(Game.player[0].getBufferedImage(), x,y,w,h, null);
		if(facing==0)g.drawImage(Game.player[1].getBufferedImage(), x,y,w,h, null);
		if(facing==3)g.drawImage(Game.player[2].getBufferedImage(), x,y,w,h, null);
		if(facing==2)g.drawImage(Game.player[3].getBufferedImage(), x,y,w,h, null);
		
	}

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		
	}

}
