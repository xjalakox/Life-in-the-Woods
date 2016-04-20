package rpg.tile;

import java.awt.Color;
import java.awt.Graphics;

import rpg.Game;
import rpg.Handler;
import rpg.Id;

public class door extends Tile {

	public door(int x, int y, int w, int h, Id id, Handler handler,boolean solid, long arrayzahl) {
		super(x, y, w, h, id, handler, solid, arrayzahl);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Game.sprites[(int) arrayzahl].getBufferedImage(), x*2,y*2,w*2,h*2, null);
		g.setColor(Color.GREEN);
		//g.drawRect(x*2, y*2, w*2, h*2);
		g.drawRect(getX()*2, getY()*2, w*2, h*2);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

}
