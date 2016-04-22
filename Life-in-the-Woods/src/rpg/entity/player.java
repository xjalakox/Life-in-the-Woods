package rpg.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import rpg.Game;
import rpg.Handler;
import rpg.Id;
import rpg.KeyInput;
import rpg.tile.Tile;

public class player extends Entity {
	int frame = 0, frameDelay = 0;
	private KeyInput key;
	private int anim;

	public player(int x, int y, int w, int h, Id id, Handler handler, KeyInput key) {
		super(x, y, w, h, id, handler);
		this.key = key;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		if(!key.left&&!key.up&&!key.down&&!key.right){
			g.drawImage(Game.player[anim*9].getBufferedImage(), x, y, w, h, null);
		}else if(!key.left&&!key.right&&!key.up){
			g.drawImage(Game.player[18+frame].getBufferedImage(), x,y,w,h, null);
			anim = 2;
		}else if(!key.left&&!key.right&&!key.down){
			g.drawImage(Game.player[0+frame].getBufferedImage(), x,y,w,h, null);
			anim = 0;
		}else if(!key.up&&!key.right&&!key.down){
			g.drawImage(Game.player[9+frame].getBufferedImage(), x,y,w,h, null);
			anim = 1;
		}else if(!key.left&&!key.up&&!key.down){
			g.drawImage(Game.player[27+frame].getBufferedImage(), x,y,w,h, null);
			anim = 3;
		}
		g.setColor(Color.BLUE);
		g.drawRect(getX()+7, getY()+65, getW()-14, getH()-65);
	}

	@Override
	public void tick() {
		if(key.coordinate){
			System.out.println("X: " + getX() + "Y: " + getY());
		}
		if(!collision()) {
			if(key.up) {
				if(key.running)y -=6; else y-=3;
				animate();
			} else if(key.down) {
				if(key.running)y +=6; else y+=3;
				animate();
			} else if(key.right) {
				if(key.running)x +=6; else x+=3;
				animate();
			} else if(key.left) {
				if(key.running)x -=6; else x-=3;
				animate();
			}
		}
	}
	
	private boolean collision() {
		for(Tile t : Handler.tile){
			if(t.getId()==Id.door||t.getId()==Id.obj){
				if(getBounds().intersects(t.getBounds())){
					key.up = false;
				}
			}
		}
		return false;
	}
	
	public void animate(){
		frameDelay++;
        if(frameDelay>=4&&key.running){
            frame++;
            if(frame>=9) {
               frame = 1;
            }
        frameDelay = 0;
        }else
        if(frameDelay>=8){
        	 frame++;
             if(frame>=9) {
                frame = 1;
             }
         frameDelay = 0;
        }	
	}
}
