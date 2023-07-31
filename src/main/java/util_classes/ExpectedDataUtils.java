package util_classes;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import model_classes.NewsletterModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ExpectedDataUtils {
    private static List<NewsletterModel> objectList;

    static {
        objectList = new ArrayList<>();

        try {
            FileReader reader = new FileReader(".\\src\\main\\resources\\test_data_files\\expected-newsletter-data.json");
            JsonElement jsonData = JsonParser.parseReader(reader);
            JsonArray jsonArray = jsonData.getAsJsonArray();
            Gson gson = new Gson();
            for (JsonElement element : jsonArray) {
                NewsletterModel model = gson.fromJson(element, NewsletterModel.class);
                objectList.add(model);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<NewsletterModel> getAllExpectedData() {
        return objectList;
    }
}