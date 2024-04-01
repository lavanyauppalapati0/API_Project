package APIpractise;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.path.json.JsonPath;
import pojopractise.GetCourse;
import pojopractise.webAutomation;

public class OauthPractice {
	public static void main(String[] args) {
	String resp =	given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust").when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
		.then().log().all().extract().response().asString();
	System.out.println(resp);
	JsonPath js = new JsonPath(resp);
	String Accesstoken = js.getString("access_token");
	
	GetCourse gc=	given().queryParam("access_token", Accesstoken).when()
	.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
	.then().log().all().extract().response().as(GetCourse.class);
	System.out.println(gc.getLinkedIn());
	System.out.println(gc.getInstructor());
	System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
	 List<webAutomation> CourseTitles = gc.getCourses().getWebAutomation();
	 
	 for(int i=0;i<CourseTitles.size();i++) {
		  System.out.println(CourseTitles.get(i).getCourseTitle());
	 }
		}

}
