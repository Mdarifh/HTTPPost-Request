package RestAssuresDay1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
given()
contain type, set cookies, add auth, add param, set headers info etc...

when()
get,post,put,delete,petch

then()
validate status code, extract response, extract headers, cookies & response body
*/


public class HTTPRequest {
	int id;
	@Test(priority=1)
	void getUser() 
		
	{
		given()
		
		.when()
		
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
		
	}
	
	@Test(priority=2)
	void CreateUser() 
	{
		HashMap data = new HashMap();
		data.put("name", "MD ARIF HUSSAIN");
		data.put("job", "AUTOMATION TESTER");
		
		
		id=given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		//.then()
			//.statusCode(201)
			//.log().all();		
	}
	@Test(priority=3,dependsOnMethods = {"CreateUser"})
	void UpdateUser()
	{
		HashMap data = new HashMap();
		data.put("name", "MD ASIF HUSSAIN");
		data.put("Degination", "DEVELOPER");
		
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.put("https://reqres.in/api/users/"+id)
			
		
		.then()
			.statusCode(200)
			.log().all();	
	}
	@Test(priority=4,dependsOnMethods = {"CreateUser"})
	void DeleteUser()
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(204)
			.log().all();
	}
}
