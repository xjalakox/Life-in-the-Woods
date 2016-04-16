package rpg.tile;

import java.awt.Graphics;

import rpg.Handler;
import rpg.Id;

public abstract class Tile {
	public int facing;
	public int x,y,w,h;
	public int velX,velY;
	
	public long arrayzahl;

	public Id id;
	
	public Handler handler;
	
	 Tile(int x, int y, int w, int h, Id id, Handler handler,long arrayzahl){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.id = id;
			this.handler = handler;
			this.arrayzahl = arrayzahl;
		}
	 
	public abstract void render(Graphics g);
	public abstract void tick();
}
