package pojopractise;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.serialization.Googlebody;
import com.serialization.latlag;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class specbuilder {

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

        RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
        		.setContentType(ContentType.JSON).build();
        		 
        		 
        		ResponseSpecification resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        		RequestSpecification res=given().spec(req)
        		.body(gc);

        		Response response =res.when().post("/maps/api/place/add/json").
        		then().spec(resspec).extract().response();

        		String responseString=response.asString();
        		System.out.println(responseString);
    }
}