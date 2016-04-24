package rpg;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import rpg.entity.Entity;
import rpg.json.JSONDecoder;
import rpg.tile.Backg;
import rpg.tile.BackgroundTile;
import rpg.tile.Tile;
import rpg.tile.door;
import rpg.tile.obj;

public class Handler {
	public static List<Entity> entity = new ArrayList<Entity>();
	public static List<Tile> tile = new ArrayList<Tile>();
	public static List<BackgroundTile> btile = new ArrayList<BackgroundTile>();
	
	public void render(Graphics g){
		for(Tile ti:tile){
			ti.render(g);
		}
		for(Entity en:entity){
			en.render(g);
		}
		for(BackgroundTile bti:btile){
			bti.render(g);
		}
	}
	
	public void tick(){
		for(Tile ti:tile){
			ti.tick();
		}
		for(Entity en:entity){
			en.tick();
		}
		for(BackgroundTile bti:btile){
			bti.tick();
		}
	}
	
	public void addEntity(Entity en){
		entity.add(en);
	}
	
	public void addTile(Tile ti) {
		tile.add(ti);
	}
	
	public void addBTile(BackgroundTile bti){
		btile.add(bti);
	}
	
	public void createLevel(String file){

		JSONObject map1 = JSONDecoder.loadMapData(file);
		
		
		int a = 0;
		int b = 0;

		for(int j=0;j<=21;j++){
			long opacity = (long)((JSONObject)((JSONArray)map1.get("layers")).get(j)).get("opacity");
			if(opacity==1){
				JSONArray data = (JSONArray)((JSONObject)((JSONArray)map1.get("layers")).get(j)).get("data");
				System.out.println("Welt wird geladen: " + j);
				for(int i=0;i<data.size();i++){
					long ids = (long) data.get(i);
					if(i % 100 == 0){
						b++;
						a=0;
					}
					
					if(ids==0){
						
					}else if(ids==1661||ids==1693){
						addBTile(new Backg(a*32,b*32,32,32,Id.render_player_first,this,false,(long) data.get(i)));
						//addTile(new obj(a*32,b*32,32,32,Id.render_player_first,this,false,(long) data.get(i)));
					}else if(ids>=320&&ids<=360){
						addTile(new obj(a*32,b*32,32,32,Id.nocollision,this,false,(long) data.get(i)));
					}else if(ids==193){
						addTile(new obj(a*32,b*32,32,32,Id.ground,this,false,(long) data.get(i)));
					}else if(ids>=2297&&ids<=2488){
						addTile(new door(a*32,b*32,32,32,Id.door,this,true,(long) data.get(i)));
					}else if(ids<=4000&&ids>=0){
						addTile(new obj(a*32,b*32,32,32,Id.obj,this,true,(long) data.get(i)));
					}
					a++;
				}
				b=0;
			}
			
		}
		boolean visible = Loadingscreen.frame.isVisible();
		if(visible=true){
			Loadingscreen.frame.Close();
		}
	}	
}
