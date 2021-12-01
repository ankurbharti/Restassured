package apitest;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Ecommerce {
       public String accessToken;
       public String id;
       
	 public static String baseurl = "https://ecommerceservice.herokuapp.com";
	 @Test(priority = 0, enabled = false)
	 public void sign_up()
	 {
		RestAssured.baseURI = baseurl; 
		
		String requestbody = "{\n"
				+ "	\"email\": \"ankur4567@gmail.com\",\n"
				+ "	\"password\": \"ankur@123\"\n"
				+ "}";
		
		//this time i want to know what my response is in my console
		Response response = given()
		.header("content-Type","application/json")
		.body(requestbody)
		
		.when()
		.post("/user/signup")
		
		.then()
		.assertThat().statusCode(201).and().contentType(ContentType.JSON)
		.extract().response();
		//is to print the response
		//basically the output format by default will be string cannot read
		//i have to convert it to json
		String jsonresponse = response.asString();
		//if i want to convert from normal string to json format
		JsonPath responsebody =new JsonPath(jsonresponse);
		System.out.println(responsebody.get("message"));
	 }
	 @Test(priority = 1)
	 public void login()
	 {
		RestAssured.baseURI = baseurl; 
		
		String requestbody = "{\n"
				+ "	\"email\": \"ankur4567@gmail.com\",\n"
				+ "	\"password\": \"ankur@123\"\n"
				+ "}";
		
		//this time i want to know what my response is in my console
		Response response = given()
		.header("content-Type","application/json")
		.body(requestbody)
		
		.when()
		.post("/user/login")
		
		.then()
		.assertThat().statusCode(200).and().contentType(ContentType.JSON)
		.extract().response();
		//is to print the response
		//basically the output format by default will be string cannot read
		//i have to convert it to json
		String jsonresponse = response.asString();
		//if i want to convert from normal string to json format
		JsonPath responsebody =new JsonPath(jsonresponse);
		System.out.println(responsebody.get("accessToken"));
	    accessToken = responsebody.get("accessToken");
	 }
	 @Test(priority = 2)
	 public void get()
	 {
		RestAssured.baseURI = baseurl; 
		
		//this time i want to know what my response is in my console
		Response response = given()
		.header("content-Type","application/json")
		.header("Authorization","bearer " +accessToken)
		
		.when()
		.get("/user")
		
		.then()
		.assertThat().statusCode(200).and().contentType(ContentType.JSON)
		.extract().response();
		//is to print the response
		//basically the output format by default will be string cannot read
		//i have to convert it to json
		String jsonresponse = response.asString();
		//if i want to convert from normal string to json format
		JsonPath responsebody =new JsonPath(jsonresponse);
		System.out.println(responsebody.get("users[205]._id"));
		id = responsebody.get("users[205]._id");
	 }
	 @Test(priority = 3)
	 public void delete()
	 {
		RestAssured.baseURI = baseurl; 
		
		//this time i want to know what my response is in my console
		Response response = given()
		.header("content-Type","application/json")
		.header("Authorization","bearer " +accessToken)
		
		.when()
		.delete("/user/"+id)

		.then()
		.assertThat().statusCode(200).and().contentType(ContentType.JSON)
		.extract().response();
		//is to print the response
		//basically the output format by default will be string cannot read
		//i have to convert it to json
		String jsonresponse = response.asString();
		//if i want to convert from normal string to json format
		JsonPath responsebody =new JsonPath(jsonresponse);
		System.out.println(responsebody.get("message"));
	 }
	 
	  
}
