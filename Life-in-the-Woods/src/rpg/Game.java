package rpg;



import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import rpg.entity.Entity;
import rpg.entity.player;
import rpg.gfx.Sprite;
import rpg.gfx.SpriteSheet;
import rpg.json.JSONDecoder;


@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {
	
	private static final java.lang.String FALSE = "false";
	
	public static String[] texts = new String[100];

	public static final int WIDTH = 480;
	public static final int HEIGHT = 270;
	public static final int SCALE = 4;
	
	public static final boolean DEBUG = true;
	
	private static String map1_noroof = "res/Maps/map1_noroof.json";
	private static String map1_roof = "res/Maps/map1_roof.json";
	
	public static SpriteSheet sheet;
	public static SpriteSheet[] sheets = new SpriteSheet[20];
	
	public static Camera cam;
	
	private KeyInput key;
	
	SaveGame g = new SaveGame();
	
	public static long[] data = new long[10000];
	
	public static Sprite[] player = new Sprite[36];
	
	private int fps,ups;
	
	public static Sprite[] sprites = new Sprite[4000];
	public static Sprite bg,ground;
	
	private boolean running = false;
	private Thread thread;
	
	private Color textc = new Color(138,60,34);
	
	public static Handler handler;
	
	public Image scrolltext_bg = new ImageIcon(this.getClass().getResource("/Scrolltext/background.png")).getImage();;
	public ImageObserver observer;
	
	
	public synchronized void start() {
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
		key.tick();
		for(Entity e:Handler.entity){
			if(e.getId()==Id.player) {
				cam.tick(e);
			}
		}
		
	}

	public void render() {
		if(KeyInput.debug){
			String s = texts[0];
			char[] c = s.toCharArray();
			String test = "";
			for(int i = 0; i < c.length; i++){
				BufferStrategy bs = getBufferStrategy();
				if(bs==null) {
					createBufferStrategy(4);
					return;
				}
				Graphics g = bs.getDrawGraphics();
				Graphics2D g2d = (Graphics2D)g;
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, WIDTH*SCALE+100, HEIGHT*SCALE+100);
				
				g2d.translate(cam.getX(), cam.getY());
				handler.render(g);
				g2d.translate(-cam.getX(), -cam.getY());
				
				/*CODE FÜR SCROLLTEXT*/
				test = test + c[i];
				g.setFont(g.getFont().deriveFont(Font.PLAIN, 40));
				g.setColor(textc);
				g.drawImage(scrolltext_bg, 700, 900, observer);
				g.drawString(test, 800, 1000);
				pause(100);
				/*CODE FÜR SCROLLTEXT*/
				
				g.dispose();
				bs.show();
			}
		}else{
			BufferStrategy bs = getBufferStrategy();
			if(bs==null) {
				createBufferStrategy(4);
				return;
			}
			Graphics g = bs.getDrawGraphics();
			Graphics2D g2d = (Graphics2D)g;
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, WIDTH*SCALE+100, HEIGHT*SCALE+100);
			
			g2d.translate(cam.getX(), cam.getY());
			handler.render(g);
			g2d.translate(-cam.getX(), -cam.getY());
			
			g.dispose();
			bs.show();
		}
	}

	public void init(){
		
		SaveGame game = new SaveGame();
		game.setName("Leon der Suckhoff");
		
		texts[0] = "Hallo " + game.getName().toString() + " wie geht es dir?";
		
		handler = new Handler();
		
     	sheet = new SpriteSheet("/Character/normal.png");
     	
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
     	
     	JSONObject map1 = JSONDecoder.loadMapData(map1_noroof);
		
     	int z = 0;
     	
		for(int a=0;a<13;a++){
			JSONObject data1 = (JSONObject) ((JSONArray)map1.get("tilesets")).get(a);
			long width = (long) data1.get("imagewidth") / 32;
			long height = (long) data1.get("imageheight") /32 ;
			
			System.out.println("Spritesheet wird ausgelesen: " + a);
			for(int b=0;b<height;b++){
				for(int c=0;c<width;c++){
					sprites[z+1] = new Sprite(sheets[a],((int)(c*32)),((int)(b*32)),32,32);
					z++;
				}
			}
		}
		
		cam = new Camera();		
		key = new KeyInput();
		addKeyListener(key);
		handler.addEntity(new player(2000,2000,60,84,Id.player,handler, key));
		
		int p = 0;
     	
    	for(int i=0;i<player.length/4;i++){
    		player[i] = new Sprite(sheet, p+17, 523, 30,52);
    		p+=64;
    	}
    	p=0;
    	for(int i=9;i<player.length/4+9;i++){
    		player[i] = new Sprite(sheet, p+17, 587, 30,52);
    		p+=64;
    	}
    	p=0;
    	for(int i=18;i<player.length/4+18;i++){
    		player[i] = new Sprite(sheet, p+17, 650, 30,52);
    		p+=64;
    	}
    	p=0;
    	for(int i=27;i<player.length/4+27;i++){
    		player[i] = new Sprite(sheet, p+17, 714, 30,52);
    		p+=64;
    	}
    	
    	LevelChanger.ChangeMusic(1,1,false);
    	LevelChanger.ChangeLevel("res/Maps/map1_roof.json");
		
		
		
	
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
		int frames = 0;
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
			frames++;
			if(System.currentTimeMillis()-timer>1000) {
				timer+=1000;
				fps = frames;
				ups = ticks;
				frames = 0;
				ticks = 0;
				System.out.println("FPS: " + fps);
				System.out.println("Ticks: " + ups);
			}
		}
		stop();
	}
	
	public Game() {
		Dimension size = new Dimension(WIDTH*SCALE, HEIGHT*SCALE);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);

	}
	
	public void pause(int test){
		try {
			Thread.sleep(test);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int getFrameWidth() {
		return WIDTH*SCALE;
	}
	
	public static int getFrameHeight() {
		return HEIGHT*SCALE;
	}
	
	

}
