package rpg.tile;

import java.awt.Graphics;

import rpg.Game;
import rpg.Handler;
import rpg.Id;

public class obj extends Tile{

	public obj(int x, int y, int w, int h, Id id, Handler handler, long arrayzahl) {
		super(x, y, w, h, id, handler,arrayzahl);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Game.sprites[(int) arrayzahl].getBufferedImage(), x,y,w,h, null);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
