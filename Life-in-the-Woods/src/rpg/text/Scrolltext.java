package rpg.text;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Scrolltext extends JFrame{
	
	
	public Scrolltext(){
	    setDefaultCloseOperation(Scrolltext.EXIT_ON_CLOSE);	    
        
	    
	}
	
	
	
	

    public void paint(Graphics g){
    	g.clearRect(0, 0, getWidth(), getHeight());
    	
		String s = "Hallo, Welt ich bin schwul und hei�e Timo und ficke gerne Daumenknicks Lena die auch ein Mann ist";
		g.setColor(Color.BLUE);
		char[] c = s.toCharArray();
		String test = "";

		for(int i = 0; i < c.length; i++){
			test = test + c[i];
			g.drawString(test, 10, 100);
			pause(10);
		}

			
    	
    }
    
	public void pause(int test){
		try {
			Thread.sleep(test);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}