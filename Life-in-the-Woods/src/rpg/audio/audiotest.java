package rpg.audio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class audiotest {
	private static String file1 = "res/Sound/hi.mp3";
	public static void main(String args[]){
		try {
			FileInputStream fis = new FileInputStream(file1);
			BufferedInputStream bis = new BufferedInputStream(fis);
		
		try{
			
			Player player = new Player(bis);
			player.play();
			
		}catch(JavaLayerException ex){}
		
		}catch(IOException e){}
	}
}
