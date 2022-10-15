package Petstore.api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import Petstore.api.payload.User;
import io.restassured.response.Response;

public class Userendpoints {
	
	
	public static Response Createuser(User Payload) {
		
		Response response=given()
			.contentType("application/json")
			.accept("application/json")
			.body(Payload)
		.when()
			.post(Routes.Createuser_url);
		
		return response;
		
	}
	
	public static Response Getuser(String Username) {
		
		Response response=given()
			.accept("application/json")
			.pathParam("uname", Username)
		.when()
			.get(Routes.getuser_url);
		
		return response;
		
	}
	
	public static Response Updateuser(String Username,User Payload) {
		
		Response response=given()
			.contentType("application/json")
			.accept("application/json")
			.body(Payload)
			.pathParam("uname", Username)
		.when()
			.put(Routes.updateuser_url);
		
		return response;
		
	}
	
	public static Response Deleteuser(String Username) {
		
		Response response=given()
			.accept("application/json")
			.pathParam("uname", Username)
		.when()
			.delete(Routes.deleteuser_url);
		
		return response;
		
	}
	
	
	

}
