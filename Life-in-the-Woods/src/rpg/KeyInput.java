package rpg;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener, FocusListener {
	
	private boolean[] keyStates;
	public boolean up, left, down, right;
	public static boolean debug;
	
	public KeyInput() {
		keyStates = new boolean[120];
	}
	
	public void tick() {
		up = keyStates[KeyEvent.VK_UP] || keyStates[KeyEvent.VK_W];
		down = keyStates[KeyEvent.VK_DOWN] || keyStates[KeyEvent.VK_S];
		left = keyStates[KeyEvent.VK_LEFT] || keyStates[KeyEvent.VK_A];
		right = keyStates[KeyEvent.VK_RIGHT] || keyStates[KeyEvent.VK_D];
		debug = keyStates[KeyEvent.VK_J];
		
		for (int i = 0; i < keyStates.length-1; i++) {
			if(keyStates[i]) {
				System.out.println("KEY: " + i);
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keyStates[e.getKeyCode()] = true;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		keyStates[e.getKeyCode()] = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		for(int i = 0; i < keyStates.length; i++) {
			keyStates[i] = false;
		}
		
	}
	
	/*public static boolean text;
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
	}*/
	/*
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		for(Entity en: Handler.entity) {
			if(en.getId()==Id.player){
				switch (key) {
					case KeyEvent.VK_D:
						en.setVelX(3);
						en.facing = 3;
						en.animate = true;
					break;
					case KeyEvent.VK_A:
						en.setVelX(-3);
						en.facing = 0;
						en.animate = true;
					break;
					case KeyEvent.VK_W:
						en.setVelY(-3);
						en.facing = 2;
						en.animate = true;
					break;
					case KeyEvent.VK_S:
						en.setVelY(3);
						en.facing = 1;
						en.animate = true;
					break;
					case KeyEvent.VK_ESCAPE:
						System.exit(0);
					break;
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity en : Handler.entity) {
			if(en.getId()==Id.player){
				switch (key) {
				case KeyEvent.VK_D:
					en.setVelX(0);
					en.animate = false;
				break;
				case KeyEvent.VK_A:
					en.setVelX(0);
					en.animate = false;
				break;
				case KeyEvent.VK_W:
					en.setVelY(0);
					en.animate = false;
				break;
				case KeyEvent.VK_S:
					en.setVelY(0);
					en.animate = false;
				break;
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}*/
}
