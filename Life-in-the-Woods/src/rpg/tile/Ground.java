package rpg.tile;

import java.awt.Graphics;

import rpg.Game;
import rpg.Handler;
import rpg.Id;

public class Ground extends Tile{

	public Ground(int x, int y, int w, int h, Id id, Handler handler) {
		super(x, y, w, h, id, handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Game.ground.getBufferedImage(), x,y,w,h, null);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
