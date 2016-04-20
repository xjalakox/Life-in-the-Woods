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
	private int test;

	public player(int x, int y, int w, int h, Id id, Handler handler, KeyInput key) {
		super(x, y, w, h, id, handler);
		this.key = key;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		if(!key.left&&!key.up&&!key.down&&!key.right){
			g.drawImage(Game.player[test*9].getBufferedImage(), x, y, w, h, null);
		}else if(!key.left&&!key.right&&!key.up){
			g.drawImage(Game.player[18+frame].getBufferedImage(), x,y,w,h, null);
			test = 2;
		}else if(!key.left&&!key.right&&!key.down){
			g.drawImage(Game.player[0+frame].getBufferedImage(), x,y,w,h, null);
			test = 0;
		}else if(!key.up&&!key.right&&!key.down){
			g.drawImage(Game.player[9+frame].getBufferedImage(), x,y,w,h, null);
			test = 1;
		}else if(!key.left&&!key.up&&!key.down){
			g.drawImage(Game.player[27+frame].getBufferedImage(), x,y,w,h, null);
			test = 3;
		}
		g.setColor(Color.BLUE);
		g.drawRect(x, y, w, h);
	}

	@Override
	public void tick() {
		if(key.up) {
			y -= 5;
			animate();
		} else if(key.down) {
			y += 5;
			animate();
		} else if(key.right) {
			x += 5;
			animate();
		} else if(key.left) {
			x -= 5;
			animate();
		}
	}
	
	public void animate(){
		frameDelay++;
        if(frameDelay>=5) {
            frame++;
            if(frame>=9) {
               frame = 0;
            }
        frameDelay = 0;
        }
        
		
	}
}
