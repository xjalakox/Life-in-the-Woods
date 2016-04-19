package rpg;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import rpg.entity.Entity;
import rpg.entity.player;
import rpg.json.JSONDecoder;
import rpg.tile.Tile;
import rpg.tile.obj;

public class Handler {
	public static List<Entity> entity = new ArrayList<Entity>();
	public static List<Tile> tile = new ArrayList<Tile>();
	
	public void render(Graphics g){
		for(Tile ti:tile){
			ti.render(g);
		}
		for(Entity en:entity){
			en.render(g);
		}
	}
	
	public void tick(){
		for(Tile ti:tile){
			ti.tick();
		}
		for(Entity en:entity){
			en.tick();
		}
	}
	
	public void addEntity(Entity en){
		entity.add(en);
	}
	
	public void addTile(Tile ti) {
		tile.add(ti);
	}
	
	public void createLevel(String file){
		addEntity(new player(1200,1200,60,84,Id.player,this));

		JSONObject map1 = JSONDecoder.loadMapData(file);
		
		int a = 0;
		int b = 0;
		
		

		for(int j=0;j<=21;j++){
			long opacity = (long)((JSONObject)((JSONArray)map1.get("layers")).get(j)).get("opacity");
			if(opacity==1){
				JSONArray data = (JSONArray)((JSONObject)((JSONArray)map1.get("layers")).get(j)).get("data");
				System.out.println("Welt wird geladen: " + j);
				for(int i=0;i<data.size();i++){ 
					long test1 = (long) data.get(i);
					if(i % 100 == 0){
						b++;
						a=0;
					}
					if(test1==0){
							
					}else if(test1<=4000&&test1>=0){
						addTile(new obj(a*32,b*32,32,32,Id.obj,this,(long) data.get(i)));
					}
					a++;
				}
				b=0;
			}else{
				System.out.println("nicht zeichnen :)");
			}
		}
	}

}
