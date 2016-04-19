package rpg.entity;

import java.awt.Color;
import java.awt.Graphics;

import rpg.Game;
import rpg.Handler;
import rpg.Id;
import rpg.KeyInput;

public class player extends Entity {
	int frame = 0, frameDelay = 0;
	private KeyInput key;

	public player(int x, int y, int w, int h, Id id, Handler handler, KeyInput key) {
		super(x, y, w, h, id, handler);
		this.key = key;
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
		/*x+=velX;
		y+=velY;*/
		
		//System.out.println(key.up);
		//System.out.println(key);
		
		if(key.up) {
			// AnimSprite up
			y -= 5;
		} else if(key.down) {
			y += 5;
		} else if(key.right) {
			x += 5;
		} else if(key.left) {
			x -= 5;
		}
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
