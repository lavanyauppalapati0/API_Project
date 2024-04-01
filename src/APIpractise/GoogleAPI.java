package APIpractise;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.PayLoad;
public class GoogleAPI {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Validate ADD place API is working or not
		
RestAssured.baseURI= "https://rahulshettyacademy.com";

String response = given().log().all().queryParam("Key","qaclick123").header("Content-Type","application/json")
.body(PayLoad.AddPlace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
.body("scope", equalTo("APP")).header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
System.out.println(response);
JsonPath js = new JsonPath(response);
String Placeid=js.getString("place_id");
System.out.println(Placeid);
String newAddress = "Summer Walk, Africa";
given().log().all().queryParam("Key", "qaclick123").header("Content-Type","application/json")
.body("{\r\n" + 
		"\"place_id\":\""+Placeid+"\",\r\n" + 
		"\"address\":\""+newAddress+"\",\r\n" + 
		"\"key\":\"qaclick123\"\r\n" + 
		"}").when().put("maps/api/place/update/json").then()
.assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

String getPlaceResponse=	given().log().all().queryParam("key", "qaclick123")
.queryParam("place_id",Placeid)
.when().get("maps/api/place/get/json")
.then().assertThat().log().all().statusCode(200).extract().response().asString();	
	
	JsonPath js1 =new JsonPath(getPlaceResponse);
	String actualaddress = js1.getString("address");
	System.out.println(actualaddress);
	Assert.assertEquals(actualaddress,newAddress );
	}

}
