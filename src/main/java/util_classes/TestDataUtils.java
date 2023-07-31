package util_classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestDataUtils {
    
    private static String testEmail;

    static {
        try {
            FileReader reader = new FileReader(".\\src\\main\\resources\\test_data_files\\testdata.json");
            JsonObject config = JsonParser.parseReader(reader).getAsJsonObject();
            testEmail = config.get("testEmail").getAsString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getTestEmail() {
        return testEmail;
    }
}