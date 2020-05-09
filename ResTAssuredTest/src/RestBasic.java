import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;




public class RestBasic {

	@Test
	public void test1()
	{
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://maps.googleapis.com/";
		
		given().
		 	param("location","-33.8670522,151.1957362").
	 		param("radius","1500").
	 		param("type","restaurant").
	 		param("keyword","cruise").
	 		param("key","AIzaSyDSUsuCYlhanBXjyCPbQBwdRCCLWypRltc").
	 		
		when().
		  get("maps/api/place/nearbysearch/json").
		  
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("results[0].name",equalTo("Cruise Bar"));
		
		
		
	}

}