package rpg.entity;

import java.awt.Graphics;

import rpg.Handler;
import rpg.Id;

public abstract class Entity {
	public int facing;
	public int x,y,w,h;
	public int velX,velY;

	public Id id;
	
	public Handler handler;
	public boolean animate;
	
	 public Entity(int x, int y, int w, int h, Id id, Handler handler){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.id = id;
			this.handler = handler;
		}
	 
	public abstract void render(Graphics g);
	public abstract void tick();
	
	public int getFacing() {
		return facing;
	}
	
	public void setFacing(int facing) {
		this.facing = facing;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getW() {
		return w;
	}
	
	public void setW(int w) {
		this.w = w;
	}
	
	public int getH() {
		return h;
	}
	
	public void setH(int h) {
		this.h = h;
	}
	
	public int getVelX() {
		return velX;
	}
	
	public void setVelX(int velX) {
		this.velX = velX;
	}
	
	public int getVelY() {
		return velY;
	}
	
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public Id getId() {
		return id;
	}
	
	public void setId(Id id) {
		this.id = id;
	}
}
