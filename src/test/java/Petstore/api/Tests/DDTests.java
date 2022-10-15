package Petstore.api.Tests;

import org.testng.annotations.Test;

import Petstore.api.endpoints.Userendpoints;
import Petstore.api.payload.User;
import Petstore.api.utilities.Dataproviders;
import io.restassured.response.Response;

public class DDTests {
	
	
	@Test(priority=1, dataProvider="Data",dataProviderClass=Dataproviders.class)
	
	public void testpostuser(String userID, String userName,String fname,String lname,String useremail,String pwd,String ph) {
		
		User Userpayload= new User();
		
		Userpayload.setId(Integer.parseInt(userID));
		Userpayload.setFirstname(fname);
		Userpayload.setLastname(lname);
		Userpayload.setPassword(pwd);
		Userpayload.setPhone(ph);
		Userpayload.setUsername(userName);
		Userpayload.setEmail(useremail);
		
		
		Response response=Userendpoints.Createuser(Userpayload);
		
		response.then().log().all();
		
		
	}
	
@Test(priority=2, dataProvider="UserNames",dataProviderClass=Dataproviders.class)
	
	public void testdeleteuser(String usernames) {
		
		
		
		
		Response response=Userendpoints.Deleteuser(usernames);
		
		response.then().log().all();
		
		
	}

}
