package rpg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import rpg.entity.Entity;

public class KeyInput implements KeyListener {
	
	public static boolean text;
	public static int textid;
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity en: Handler.entity) {
			if(en.getId()==Id.player){
				if(key == KeyEvent.VK_D){
					en.setVelX(3);
					en.facing = 3;
					en.animate = true;
				}
				if(key == KeyEvent.VK_A){
					en.setVelX(-3);
					en.facing = 0;
					en.animate = true;
				}
				if(key == KeyEvent.VK_W){
					en.setVelY(-3);
					en.facing = 2;
					en.animate = true;
				}
				if(key == KeyEvent.VK_S){
					en.setVelY(3);
					en.facing = 1;
					en.animate = true;
				}
				if(key == KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
				if(Game.DEBUG)if(key == KeyEvent.VK_J){
					//LevelChanger.ChangeMusic(3,1,true);
					text = true;
					textid = 0;
				}
				
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity en : Handler.entity) {
			if(en.getId()==Id.player){
				if(key == KeyEvent.VK_D) en.setVelX(0); en.animate = false;
				if(key == KeyEvent.VK_A) en.setVelX(0); en.animate = false;
				if(key == KeyEvent.VK_W) en.setVelY(0); en.animate = false;
				if(key == KeyEvent.VK_S) en.setVelY(0); en.animate = false;
				
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
