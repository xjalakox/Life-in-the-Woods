package rpg;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import rpg.entity.Entity;
import rpg.gfx.ImageLoader;
import rpg.gfx.Sprite;
import rpg.gfx.SpriteSheet;
import rpg.json.JSONDecoder;

import static java.lang.Math.toIntExact;


@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {

	public static final int WIDTH = 320;
	public static final int HEIGHT = 180;
	public static final int SCALE = 4;
	
	private static String file1 = "res/Maps/map1.json";
	
	public static SpriteSheet sheet,sheet2,sheet3;
	public static SpriteSheet[] sheets = new SpriteSheet[20];
	
	public static Camera cam;
	
	public static long[] data = new long[10000];
	
	public static Sprite[] player = new Sprite[20];
	
	public static Sprite[] sprites = new Sprite[4000];
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
		
		handler = new Handler();
		
     	sheet = new SpriteSheet("/character.png");
     	sheet2 = new SpriteSheet("/Tiles/nature.png");
     	sheet3 = new SpriteSheet("/Tiles/rpg set.png");
     	
     	sheets[0] = new SpriteSheet("/Tiles/nature.png");
     	sheets[1] = new SpriteSheet("/Tiles/rpg set.png");
     	sheets[2] = new SpriteSheet("/Tiles/floor wood.png");
     	sheets[3] = new SpriteSheet("/Tiles/windows.png");
     	sheets[4] = new SpriteSheet("/Tiles/doors.png");
     	sheets[5] = new SpriteSheet("/Tiles/flowerpots.png");
     	sheets[6] = new SpriteSheet("/Tiles/kitchen.png");
     	sheets[7] = new SpriteSheet("/Tiles/furniture.png");
     	sheets[8] = new SpriteSheet("/Tiles/furniture2.png");
     	sheets[9] = new SpriteSheet("/Tiles/trees2.png");
     	sheets[10] = new SpriteSheet("/Tiles/paintings.png");
     	sheets[11] = new SpriteSheet("/Tiles/statues.png");
     	sheets[12] = new SpriteSheet("/Tiles/trees.png");
     	
     	JSONObject map1 = JSONDecoder.loadMapData(file1);
		
     	int z = 0;
     	
		for(int a=0;a<13;a++){
			JSONObject data1 = (JSONObject) ((JSONArray)map1.get("tilesets")).get(a);
			long width = (long) data1.get("imagewidth") / 32;
			long height = (long) data1.get("imageheight") /32 ;
			
			System.out.println(width + " " + height);
			for(int b=0;b<height;b++){
				for(int c=0;c<width;c++){
					sprites[z+1] = new Sprite(sheets[a], toIntExact(c*32),toIntExact(b*32),32,32);
					z++;
				}
			}
		}
		
		cam = new Camera();		
     	ground = new Sprite(sheet3, 192,64,32,32);
     	
    	player[0]=new Sprite(sheet, 27,18,32,32);
    	player[1]=new Sprite(sheet, 27,54,32,32);
    	player[2]=new Sprite(sheet, 27,89,32,32);
    	player[3]=new Sprite(sheet, 27,126,32,32);
    	
		handler.createLevel();
		addKeyListener(new KeyInput());
	}
	
	@Override
	public void run() {
		init();
		requestFocus();
		long lastTime = System.nanoTime();
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
