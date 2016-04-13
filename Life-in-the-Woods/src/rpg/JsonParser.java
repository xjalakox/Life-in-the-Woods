package rpg;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

	private static final String filePath = "C:\\Users\\jalak\\Desktop\\Json Dateien\\map.json";
	
	public static void outputJSON(long[] array, String JsonName){
		try {
			FileReader reader = new FileReader(filePath);

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			
			JSONArray test2 = (JSONArray) jsonObject.get(JsonName);
			
			
			for(int i=0; i<test2.size(); i++){
				array[i] = (long) test2.get(i);
				//System.out.println(array[i]);
			}
			
			Iterator i = test2.iterator();
			
			while (i.hasNext()) {
				JSONObject innerObj = (JSONObject) i.next();
				System.out.println(innerObj.get("data"));
			}
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			System.out.println("JsonName falsch, oder irgendwas anderes?");
			ex.printStackTrace();
		}
	}
}
