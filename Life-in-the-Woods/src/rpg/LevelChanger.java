package rpg;

import rpg.audio.SoundManager;

public class LevelChanger {
	static SoundManager manager = new SoundManager();
	
	public static void ChangeLevel(String levelPath,boolean[] collision){
		Game.handler.clearLevel();
		Game.handler.createLevel(levelPath,collision);
	}
	
	public static void ChangeMusic(int newMusicID, int oldMusicID, boolean running){
		if(oldMusicID==0){
		//	manager.playSound(newMusicID);
		}else if(oldMusicID==newMusicID&&!running){
		//	manager.playSound(newMusicID);
		}else if(oldMusicID==newMusicID){
			
		}else{
	//		manager.stopSound(oldMusicID);
		//	manager.playSound(newMusicID);
		}
		if(!Game.DEBUG) manager.fadeInSound(newMusicID);
	}
}
