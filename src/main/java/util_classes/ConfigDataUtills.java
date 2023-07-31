package util_classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConfigDataUtills {
	private static String url;
	
	static {
		try {
			FileReader reader = new FileReader(".\\src\\main\\resources\\config_data_files\\configdata.json");
			JsonObject config = JsonParser.parseReader(reader).getAsJsonObject();
			url = config.get("url").getAsString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static String getUrl() {
		return url;
	}			
}