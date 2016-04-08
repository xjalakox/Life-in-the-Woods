package rpg;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParseTest {

	private static final String filePath = "C:\\Users\\jalak\\Desktop\\jsonTestFile.json";
	
	public static void main(String[] args) {

		try {
			//Json Datei lesen
			FileReader reader = new FileReader(filePath);

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			// String aus JSON Object nehmen
			String firstName = (String) jsonObject.get("firstname");

			// Nummer aus JSON Object nehmen
			long id =  (long) jsonObject.get("id");

			// Array aus JSON Object nehmen
			JSONArray lang= (JSONArray) jsonObject.get("languages");
			
			// Inhalt des JSON Arrays nehmen 
			for(int i=0; i<lang.size(); i++){
				System.out.println("The " + i + " element of the array: "+lang.get(i));
			}
			Iterator i = lang.iterator();

			// Jeden Wert des JSON Arrays seperat nehmen
			while (i.hasNext()) {
				JSONObject innerObj = (JSONObject) i.next();
				System.out.println("language "+ innerObj.get("lang") + 
						" with level " + innerObj.get("knowledge"));
			}
			// Structure/Text zu JSON Object hinzufügen
			JSONObject structure = (JSONObject) jsonObject.get("job");
			System.out.println("Into job structure, name: " + structure.get("name"));

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

	}

}