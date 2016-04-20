package rpg;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
 
public class SaveGame {
     
    private Scanner scan;
    private File savegame = new File("res/Savegames/savegame.txt");
     
     
     
    private String name;
     
     
     
    public SaveGame() {
        if(savegame.exists()) {
            try {
                scan = new Scanner(savegame);
                read();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            setToDefault();
            System.out.println("SetToDefault() Amina");
        }
         
    }
     
    public void read() {
        if(scan.hasNext()){
            try{
                this.name = scan.next();
            } catch (Exception e) {
                //setToDefault();
            }
        } else {
            setToDefault();
        }
    }
     
    public void write() {
        try {
            Formatter formatter = new Formatter(savegame);
            formatter.format
            ("%s ", "Name: " + name);
            formatter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    public void setToDefault() {
         
        this.name = "g�nther";
                                 
        write();
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
        write();
    }
     
}