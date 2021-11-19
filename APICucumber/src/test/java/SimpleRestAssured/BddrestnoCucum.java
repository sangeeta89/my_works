package SimpleRestAssured;

import static io.restassured.RestAssured.*;

public class BddrestnoCucum {
	static String uri="http://demo.guru99.com/V4/sinkministatement.php";
	
	public static void getResponseBody(){
		   given().queryParam("CUSTOMER_ID","68195")
		   				 .queryParam("PASSWORD","1234!")
		   				 .queryParam("Account_No","1")
		   				 .when().get(uri).then().log()
		   				 .body();
		 
		}
	public static void getResponseStatus() {
		
		int statusCode=given().queryParam("CUSTOMER_ID","68195")
  				 .queryParam("PASSWORD","1234!")
  				 .queryParam("Account_No","1")
  				 .when().get(uri).getStatusCode();
		System.out.println("The response status code is "+statusCode);
		
		
	}
	
	public static void main(String ar[]) {
		BddrestnoCucum.getResponseBody();
		BddrestnoCucum.getResponseStatus();
	}
}
