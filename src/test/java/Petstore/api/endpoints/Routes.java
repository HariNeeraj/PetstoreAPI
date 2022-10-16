package Petstore.api.endpoints;


/* 
Swagger URI --> https://petstore.swagger.io

Create user(Post) : https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user/{username}
Update user (Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}

*/


public class Routes {
	
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Endpoints
	
	public static String Createuser_url= base_url+"/user";
	public static String getuser_url= base_url+"/user/{uname}";
	public static String updateuser_url= base_url+"/user/{uname}";
	public static String deleteuser_url= base_url+"/user/{uname}";
	public static String Loginuser_url= base_url+"/user/login";	
	public static String Logoutuser_url = base_url+"/user/logout";
	
	

}
