package APIpractise;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.PayLoad;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class dynamicJson {
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn , String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		String resp = given().header("Content-Type","application/json")
		.body(PayLoad.addlibrary(isbn,aisle)).when()
		.post("/Library/Addbook.php").then().log().all()
		.assertThat().statusCode(200).extract().response().asString();
		JsonPath js= ReUsableMethods.rawToJson(resp);

		   String id=js.get("ID");

		   System.out.println(id);
		  // System.out.println(id);
	}
@DataProvider(name="BooksData")
public Object[][] getdata(String isbn , String aisle) {
 return	new Object[][]  {{"USL","2867"},{"UMR","8019"},{"UBR","6369"}};
}
}
