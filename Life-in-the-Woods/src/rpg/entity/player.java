package rpg.entity;

import java.awt.Color;
import java.awt.Graphics;

import rpg.Game;
import rpg.Handler;
import rpg.Id;

public class player extends Entity {
	int frame = 0, frameDelay = 0;

	public player(int x, int y, int w, int h, Id id, Handler handler) {
		super(x, y, w, h, id, handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		if(facing==1)g.drawImage(Game.player[18+frame].getBufferedImage(), x,y,w,h, null);
		if(facing==0)g.drawImage(Game.player[9+frame].getBufferedImage(), x,y,w,h, null);
		if(facing==3)g.drawImage(Game.player[27+frame].getBufferedImage(), x,y,w,h, null);
		if(facing==2)g.drawImage(Game.player[0+frame].getBufferedImage(), x,y,w,h, null);
		
		g.setColor(Color.BLUE);
		g.drawRect(x, y, w, h);
		
	}

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		if(animate){
			frameDelay++;
	        if(frameDelay>=5) {
	            frame++;
	            if(frame>=9) {
	               frame = 0;
	            }
	        frameDelay = 0;
	        }
		}else{
			frame = 0;
		}
	}
}
