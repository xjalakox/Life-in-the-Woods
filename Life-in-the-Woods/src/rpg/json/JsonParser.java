package rpg.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

	private static final String filePath = "C:\\Users\\jalak\\Desktop\\Json Dateien\\jsonTestFile.json";
	
	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader(filePath);

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			
			JSONArray test2 = (JSONArray) jsonObject.get("data");
			
			for(int a=0; a<test2.size(); a++){
				System.out.println("Das " + a + " Element aus Array: "+test2.get(a));
			}
			
			for(int b=0;b<=100;b++){
				System.out.println("");
				for(int c=0;c<=100;c++){
					if(b*c == 10000){
						
					}else{
						System.out.print(test2.get(b*c));
						System.out.print(" ");
					}
				}
			}

			
			
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
