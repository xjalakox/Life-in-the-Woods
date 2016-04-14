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

public class Handler {
	public static List<Entity> entity = new ArrayList<Entity>();
	public static List<Tile> tile = new ArrayList<Tile>();
	
	private static String file1 = "res/map1.json";
	
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
	
	public void createLevel(){
		addEntity(new player(100,100,54,60,Id.player,this));

		JSONObject map1 = JSONDecoder.loadMapData(file1);
		
		JSONArray test = (JSONArray)((JSONObject)((JSONArray)map1.get("layers")).get(0)).get("data");
		
		for(int i=0;i<test.size();i++){
			System.out.println(test.get(i));
			addEntity(new player(100,100+i*10,54,60,Id.player,this));
		}
		
		

		
	}

}
