package RestAssuresDay1;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import POJO.Pojo_PostRequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
/*
 Different way to create POST request body
 Post request body using hashmap
 Post request body Creating using org.json
 Post request body  Creating using POJO Class
 Post request body Creating using external json file data
 */

public class HTTPPostRequest {
	
//1.Post request body using hashmap

/*	@Test(priority=1)
	void testPostUsingHashmap()
	{
		HashMap data = new HashMap();
		data.put("name","Md Arif Hussain" );
		data.put("location","india");
		data.put("phone", "7061651398");
		String courseArr[] = {"python","Java full stack","Automation Testing","C"};
		data.put("course",courseArr);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
			.post("http://localhost:3000/StudentData")
			
		.then()
			.statusCode(201)
			.body("name",equalTo("Md Arif Hussain"))
			.body("location",equalTo("india"))
			.body("phone",equalTo("7061651398"))
			.body("course[0]",equalTo("python"))
			.body("course[1]",equalTo("Java full stack"))
			.body("course[2]",equalTo("Automation Testing"))
			.body("course[3]",equalTo("C"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
		
			
	}
	
	// delete Student record
	
	@Test(priority=2)
	void DeleteUser()
	{
		given()
		
		.when()
			.delete("http://localhost:3000/StudentData/19")
		
		.then()
			.statusCode(200);
			
	}


*/

//2.Post request body using org.json liberary

/*@Test(priority=1)
void testpostusingjsonLibery() 
{
	
	JSONObject data = new JSONObject();
	
	data.put("name", "Md Asif Hussain");
	data.put("location", "canada");
	data.put("phone","7061651391");
	String courseArr[] = {"python","Java full stack","c"};
	data.put("course", "courseArr");
	given()
	.contentType("application/json")
	.body(data.toString())
	
	.when()
		.post("http://localhost:3000/StudentData")
		
	.then()
		.statusCode(201)
		.body("name",equalTo("Md Arif Hussain"))
		.body("location",equalTo("india"))
		.body("phone",equalTo("7061651398"))
		.body("course[0]",equalTo("python"))
		.body("course[1]",equalTo("Java full stack"))
		.body("course[2]",equalTo("Automation Testing"))
		.body("course[3]",equalTo("C"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
	
		
}*/
	
	// 3.Post Request body using POJO Class
	
/*	@Test(priority=1)
	void testRequestPojo() 
	{
		Pojo_PostRequest data  = new Pojo_PostRequest();
		
		data.setName("Md Arif Hussain");
		data.setLocation("india");
		data.setPhone("7061651398");
		String courseArr[] = {"python","Java full stack","Automation Testing","C"};
		data.setCourse(courseArr);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
			.post("http://localhost:3000/StudentData")
			
		.then()
			.statusCode(201)
			.body("name",equalTo("Md Arif Hussain"))
			.body("location",equalTo("india"))
			.body("phone",equalTo("7061651398"))
			.body("course[0]",equalTo("python"))
			.body("course[1]",equalTo("Java full stack"))
			.body("course[2]",equalTo("Automation Testing"))
			.body("course[3]",equalTo("C"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
		
	}
	*/
	//4.Post request body Creating using external json file data
		
	@Test(priority=1)
	void testPostUsingExternal() throws FileNotFoundException 
	{
		File f = new File(".//body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		
	
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
			.post("http://localhost:3000/StudentData")
			
		.then()
			.statusCode(201)
			.body("name",equalTo("Md Arif Hussain"))
			.body("location",equalTo("india"))
			.body("phone",equalTo("7061651398"))
			.body("course[0]",equalTo("python"))
			.body("course[1]",equalTo("Java full stack"))
			.body("course[2]",equalTo("Automation Testing"))
			.body("course[3]",equalTo("C"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
	}
		
// delete Student record

@Test(priority=2)
void DeleteUser()
{
	given()
	
	.when()
		.delete("http://localhost:3000/StudentData/11")
	
	.then()
		.statusCode(200);
		
	}
}