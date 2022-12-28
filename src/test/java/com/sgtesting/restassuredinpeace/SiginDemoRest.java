package com.sgtesting.restassuredinpeace;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SiginDemoRest {

	public static String Auth_Token=null;
	public static String Creat_User_ID=null;
	@Test(priority=1)
	public static void sigInDemo()
	{

		try 
		{
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/students/sign_in";
			RequestSpecification httprequest=RestAssured.given();
			SignInPro pojo = new SignInPro();
			pojo.setEmail("sandeshp8660@gmail.com");
			pojo.setPassword("gowri@123");
			httprequest.header("content-type","application/json");
			httprequest.body(pojo);
			Response rr=httprequest.post();
			String response=rr.asString();
			System.out.println(response);
			JsonPath json=rr.jsonPath();
			Auth_Token=json.getString("auth_token");
			System.out.println(Auth_Token);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority=2,enabled=false)
	public static void createUser()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/users";
			RequestSpecification httprequest=RestAssured.given();
			CreateUsersScenario pojocreate=new CreateUsersScenario("LohithBro@gmail.com","Lohit","Anna","9874561230","Marlur", "Karnataka", "741258");
			httprequest.header("content-type","Application/json");			
			httprequest.body(pojocreate);
			httprequest.header("Authorization",Auth_Token);
			Response rr=httprequest.post();
			String response=rr.asString();
			System.out.println(response);
			JsonPath json=rr.jsonPath();
			Creat_User_ID=json.getString("id");
			System.out.println(Creat_User_ID);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority=3,enabled=false)
	public static void editUser()
	{
		try 
		{
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/users/"+Creat_User_ID;
			RequestSpecification httprequest=RestAssured.given();
			CreateUsersScenario pojocreate= new CreateUsersScenario("LohithBro@gmail.com","LohitRemodified","Anna","9874561230","Marlur", "Karnataka", "741258");
			httprequest.header("content-type","application/json");
			httprequest.body(pojocreate);
			httprequest.header("Authorization",Auth_Token);
			Response rres=httprequest.put();
			String Response=rres.asString();
			System.out.println(Response);
			JsonPath json=rres.jsonPath();
			String Fn=json.getString("first_name");
			System.out.println(Fn);

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority=4)
	public static void getAllUser()
	{
		try 
		{
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/users";
			RequestSpecification httprequest=RestAssured.given();
			httprequest.header("content-type","application/json");
			httprequest.header("Authorization",Auth_Token);
			Response rres=httprequest.get();
			String Response=rres.asString();
			System.out.println(Response);
//			JsonPath json=rres.jsonPath();
//			String Fn=json.getString("first_name");
//			System.out.println(Fn);

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority=5,enabled =false)
	public static void deleteUser()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/users/"+"351859";
			RequestSpecification httprequest=RestAssured.given();
			httprequest.header("content-type","Application/json");			
			httprequest.header("Authorization",Auth_Token);
			Response rr=httprequest.delete();
			String response=rr.asString();
			System.out.println(response);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static void Signout()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/students/sign_out";
			RequestSpecification httprequest=RestAssured.given();
			httprequest.header("content-type","Application/json");			
			httprequest.header("Authorization",Auth_Token);
			Response rr=httprequest.get();
			String response=rr.asString();
			System.out.println(response);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}


