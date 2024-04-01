package pojopractise;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.serialization.Googlebody;
import com.serialization.latlag;

import io.restassured.RestAssured;

public class Addplace {

    public static void main(String[] args) {
        // Setting up base URI
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // Creating instance of Googlebody
        Googlebody gc = new Googlebody();
        gc.setAccuracy("50");
        gc.setWebsite("http://google.com");
        gc.setAddress("29, side layout, cohen 09");
        gc.setLanguage("French-IN");
        gc.setPhone_number("(+91) 983 893 3937");
        gc.setName("Frontline house");

        // Creating list of types
        List<String> mylist = new ArrayList<String>();
        mylist.add("shoe park");
        mylist.add("shop");
        gc.setTypes(mylist);

        // Creating instance of latlag
        latlag l = new latlag();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        gc.setLocation(l);

        // Sending POST request and printing response
        String response = given().log().all().queryParam("Key", "qaclick123").header("Content-Type", "application/json")
                .body(gc).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println(response);
    }
}