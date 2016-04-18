package rpg;

import rpg.audio.SoundManager;

public class LevelChanger {
	static SoundManager manager = new SoundManager();
	
	public static void ChangeLevel(String levelPath){
		Game.handler.createLevel(levelPath);
	}
	
	public static void ChangeMusic(int newMusicID, int oldMusicID, boolean running){
		if(oldMusicID==0){
			manager.playSound(newMusicID);
		}else if(oldMusicID==newMusicID&&!running){
			manager.playSound(newMusicID);
		}else if(oldMusicID==newMusicID){
			
		}else{
			manager.stopSound(oldMusicID);
			manager.playSound(newMusicID);
		}
		if(!Game.DEBUG) manager.fadeInSound(newMusicID);
	}
}
