package rpg.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

	private static final String filePath = "C:\\Users\\jalak\\Desktop\\Json Dateien\\map.json";
	// layers/data23
	public static JSONObject outputJSONArray(String path){
		
		try {
			FileReader reader = new FileReader(filePath);

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			
			// Path in Parts aufteilen
			String[] parts = path.split("/");
			
			for(int i = 0; i < parts.length; i++) {
				System.out.println(parts[i]);
				if(jsonObject.get(parts[i]) instanceof JSONArray) {
					
				} else {
					
				}
				jsonObject = (JSONObject) jsonObject.get(parts[i]);
			}
			
			return jsonObject;
			/*JSONArray test2 = (JSONArray) jsonObject.get(JsonName);
			
			
			Iterator i = test2.iterator();
				
			while (i.hasNext()) {
				JSONObject innerObj = (JSONObject) i.next();
				System.out.println(innerObj.get("data"));
				//System.out.println(innerObj.get("data23"));
			}
			*/
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
		return null;
	}
	
	public static String outputJSON(String JsonName){
		String variable = "test";
		try {
			FileReader reader = new FileReader(filePath);
	
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			
			variable = (String) jsonObject.get(JsonName);
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			System.out.println("JsonName falsch, oder irgendwas anderes?");
			ex.printStackTrace();
		}return variable;
	}
}
