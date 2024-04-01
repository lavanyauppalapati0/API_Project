package APIpractise;

import org.testng.Assert;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class PractiseJSONparse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(PayLoad.Mockapi());
		
	int count	=js.getInt("courses.size()");
	System.out.println(count);
  int purchaseamount =  js.getInt("dashboard.purchaseAmount");
   System.out.println(purchaseamount);
   
   String firstcoursename = js.getString("courses[0].title");
   System.out.println(firstcoursename);
   
   for(int i=0;i<count;i++) {
	   
	 System.out.println("The course name is :"+(js.getString("courses["+i+"].title")));
	 System.out.println("and the price is  :"+js.getInt("courses["+i+"].price"));
   
   
   String CoursesTitles= js.getString("courses["+i+"].title");
   
   if(CoursesTitles.equalsIgnoreCase("RPA")) {
	   System.out.println("the number of copies sold  :"+(js.getInt("courses.copies["+i+"]")));
	   break;
   }
	}
   int sum = 0;

   for (int i = 0; i < count; i++) {
       int price = js.getInt("courses[" + i + "].price");
       int copies = js.getInt("courses[" + i + "].copies");
       int amount = price * copies;
       System.out.println(amount);
       sum = sum + amount;
   }
   System.out.println(sum);
   int purchaseAmount = js.getInt("dashboard.purchaseAmount");
   Assert.assertEquals(sum, purchaseAmount);
}
	}
	

