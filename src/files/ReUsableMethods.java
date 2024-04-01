package files;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {

    public static JsonPath rawToJson(String response) {
        // Create a new JsonPath object from the response string
        JsonPath js = new JsonPath(response);
        // Return the JsonPath object
        return js;
    }
}
