package rpg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import rpg.entity.Entity;

public class KeyInput implements KeyListener {
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity en: Handler.entity) {
			if(en.getId()==Id.player){
				if(key == KeyEvent.VK_D){
					en.setVelX(5);
					en.facing = 3;
				}
				if(key == KeyEvent.VK_A){
					en.setVelX(-5);
					en.facing = 0;
				}
				if(key == KeyEvent.VK_W){
					en.setVelY(-5);
					en.facing = 2;
				}
				if(key == KeyEvent.VK_S){
					en.setVelY(5);
					en.facing = 1;
				}
				
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity en : Handler.entity) {
			if(en.getId()==Id.player){
				if(key == KeyEvent.VK_D) en.setVelX(0);
				if(key == KeyEvent.VK_A) en.setVelX(0);
				if(key == KeyEvent.VK_W) en.setVelY(0);
				if(key == KeyEvent.VK_S) en.setVelY(0);
				
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
