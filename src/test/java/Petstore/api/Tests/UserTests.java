package Petstore.api.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Petstore.api.endpoints.Userendpoints;
import Petstore.api.payload.User;
import io.restassured.response.Response;



public class UserTests {
	
	Faker faker;
	User Userpayload;

	
	@BeforeClass
	public void testsetup() {
		
		faker = new Faker();
		Userpayload = new User();
		
		Userpayload.setId(faker.idNumber().hashCode());
		Userpayload.setFirstname(faker.name().firstName());
		Userpayload.setLastname(faker.name().lastName());
		Userpayload.setEmail(faker.internet().safeEmailAddress());
		Userpayload.setUsername(faker.name().fullName());
		Userpayload.setPhone(faker.phoneNumber().cellPhone());
		Userpayload.setPassword(faker.internet().password(5, 9));

	}
	
	
	@Test(priority=1)
	public void CreateuserTest() {
		
		Response response = Userendpoints.Createuser(Userpayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(Userpayload.getUsername());
	}
	
	@Test(priority=2)
	public void GetuserTest() {
		
		Response response = Userendpoints.Getuser(Userpayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void UpdateuserTest() {
		
		Userpayload.setFirstname(faker.name().firstName());
		Userpayload.setLastname(faker.name().lastName());
		Userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = Userendpoints.Updateuser(this.Userpayload.getUsername(), Userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response responseafter = Userendpoints.Getuser(Userpayload.getUsername());
		responseafter.then().log().all();
		
	}
	
	
	
	@Test(dependsOnMethods= {"UpdateuserTest"})
	public void DeleteuserTest() {
		
		Response response= Userendpoints.Deleteuser(this.Userpayload.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	
	
	
}
