package rpg;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import rpg.entity.Entity;
import rpg.gfx.ImageLoader;
import rpg.gfx.Sprite;
import rpg.gfx.SpriteSheet;


@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {

	public static final int WIDTH = 320;
	public static final int HEIGHT = 180;
	public static final int SCALE = 4;
	
	public static SpriteSheet sheet,sheet2;
	
	public static Camera cam;
	
	public static long[] data = new long[10000];
	
	public static Sprite[] player = new Sprite[20];
	public static Sprite bg,ground;
	private BufferedImage background;
	
	private boolean running = false;
	private Thread thread;
	public static Handler handler;
	
	
	synchronized void start() {
		if(running) return;
		running = true;
		thread = new Thread(this, "Thread");
		thread.start();
	}
	
	private synchronized void stop() {
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
		}
	}
	public void tick() {
		handler.tick();
		for(Entity e:Handler.entity){
			if(e.getId()==Id.player) {
				cam.tick(e);
			}
		}
		
	}
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs==null) {
			createBufferStrategy(4);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D)g;
		
		//g.drawImage(background,0 , 0, getWidth(), getHeight(), this);
		g.drawRect(0, 0, WIDTH*SCALE+100, HEIGHT*SCALE+100);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH*SCALE+100, HEIGHT*SCALE+100);
		
		g2d.translate(cam.getX(), cam.getY());
		g.drawImage(background,0 , 0, 4200, 4200, this);
		handler.render(g);
		g2d.translate(-cam.getX(), -cam.getY());
		
		
		g.setColor(Color.BLUE);
		g.setFont(new Font("Verdana", Font.BOLD, 23));
		
		g.dispose();
		bs.show();
	}

	public void init(){
		//long[] test = new long[10000];
		
	//	JsonParser.outputJSON(test);
		
		
		ImageLoader loader = new ImageLoader();
		background = loader.loadImage("/map.png");
		
		handler = new Handler();
		
		cam = new Camera();
//		
     	sheet = new SpriteSheet("/character.png");
//		sheet2 = new SpriteSheet("/background_grass.png");
//		
//		bg = new Sprite(sheet2,1,1,21,15);
//		
	//	player[0]=new Sprite(sheet, 27,18,27,30);
	//	player[1]=new Sprite(sheet, 27,54,27,30);
	//	player[2]=new Sprite(sheet, 27,89,27,30);
	//	player[3]=new Sprite(sheet, 27,126,27,30);
     	
    		player[0]=new Sprite(sheet, 27,18,32,32);
    		player[1]=new Sprite(sheet, 27,54,32,32);
    		player[2]=new Sprite(sheet, 27,89,32,32);
    		player[3]=new Sprite(sheet, 27,126,32,32);
		
		//ground = new Sprite()
//		for(int i=0;i<12;i++){
//			player[i+12]=new Sprite(sheet, i+1,5,2,2);
//		}
//		
//		for(int i=0;i<12;i++){
//			player[i+24]=new Sprite(sheet, i+1,2,2,2);
//		}
//		for(int i=0;i<12;i++){
//			player[i+36]=new Sprite(sheet, i+1,6,2,2);
//		}
//	
//		for(int i=0;i<12;i++){
//			player[i+48]=new Sprite(sheet, i+1,3,2,2);
//		}
//		for(int i=0;i<12;i++){
//			player[i+60]=new Sprite(sheet, i+1,7,2,2);
//		}
//		
//		for(int i=0;i<12;i++){
//			player[i+72]=new Sprite(sheet, i+1,4,2,2);
//		}
//		for(int i=0;i<12;i++){
//			player[i+84]=new Sprite(sheet, i+1,8,2,2);
//		}
//		
//		
//		ImageLoader loader = new ImageLoader();
	//	background = loader.loadImage("/background_grass.png");
		handler.createLevel();
		addKeyListener(new KeyInput());
	}
	
	@Override
	public void run() {
		init();
		requestFocus();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0;
		double ns = 1000000000.0/60.0;
		int ticks = 0;
		while(running) {
			long now = System.nanoTime();
			delta+=(now-lastTime)/ns; 
			lastTime = now;
			while(delta>1) {
				tick();
				ticks++;
				delta--;
			}
			render();
		}
		stop();
	}
	
	public Game() {
		Dimension size = new Dimension(WIDTH*SCALE, HEIGHT*SCALE);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);

	}
	
	public static int getFrameWidth() {
		return WIDTH*SCALE;
	}
	
	public static int getFrameHeight() {
		return HEIGHT*SCALE;
	}
	
	

}
