package rpg.audio;

public enum SoundID {
    //template      (   id, name,           vol),
     
    //Music
    intro           (   0,  "intro",        3),
    world1          (   1,  "athletic",     3),
     
    //Effects
    brickeffect     (   2,  "brick",        1),
    jumpeffect      (   3,  "jump",         1),
    coineffect      (   4,  "coin",         1),
    coin_appear     (   5,  "coin_appear",  1),
    editor_menu     (   6,  "editor_menu",  1),
    akbar           (   7,  "akbar",        1),
	hi				(	8,	"hi",			1);
     
    private int id;
    private String prefix = "res/Sound/";
    private String suffix = ".mp3";
    private String name;
    // musicvol // effectvol // mastervol//
    private int[] volList = { -20, -20, -20};
    private int vol;
     
    SoundID(int id, String name, int vol) {
        this.id =id;
        this.name = name;
         
         
        for(int i = 0; i < volList.length; i++) {
            if(vol == i) {
                this.vol = volList[i];
            }
        }
    }
     
    public int getID() {
        return this.id;
    }
    public  String getPath() {
        return this.prefix + this.name + this.suffix;
    }
    public int getVolume() {
        return this.vol;
    }
}