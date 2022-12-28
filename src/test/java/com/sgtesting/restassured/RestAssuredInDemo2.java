package com.sgtesting.restassured;
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredInDemo2 {

	public static String Auth_Token =null;
	public static String ID=null;
	@Test
	public static void signIn()
	{
		try 
		{
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/students/sign_in";
			RequestSpecification httprequest=RestAssured.given();
			httprequest.header("content-type","application/json");
			File f1= new File("F:\\GitRepository\\CurrentWorkSpace\\ExampleJuly4th2022Repository\\RestInPeace\\jsonrequest\\signin.json");
			httprequest.body(f1);
			Response rr=httprequest.post();
			String Response=rr.asString();
			System.out.println(Response);
			JsonPath jp=rr.jsonPath();
			Auth_Token	=jp.getString("auth_token");
			System.out.println(Auth_Token);
			int actual,expected;
			expected=200;
			 actual=rr.getStatusCode();
			 System.out.println(actual);
			Assert.assertEquals(actual, expected);
			
			String statusline=rr.getStatusLine();
			System.out.println(statusline);
			String expectedstatus="HTTP/1.1 200 OK";
			Assert.assertTrue(statusline.equals(expectedstatus));
			
			
			Headers header=rr.getHeaders();
			for(Header headers:header)
			{
				System.out.println(headers);
			}
			// Content-Type=application/json; charset=utf-8
			String content=rr.getHeader("Content-Type");
			
			Assert.assertEquals(content,"application/json; charset=utf-8" );
			
			System.out.println("all assertion are true");
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority=1,enabled=false)
	public static void createUser()
	{
		try 
		{
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/users";
			RequestSpecification httprequest=RestAssured.given();
			httprequest.header("content-type","application/json");
			File f2 =new File("F:\\GitRepository\\CurrentWorkSpace\\ExampleJuly4th2022Repository\\RestInPeace\\jsonrequest\\createuser.json");
			httprequest.body(f2);
			httprequest.header("Authorization",Auth_Token);
			Response rr=httprequest.post();
			String Respone=rr.asString();
			System.out.println(Respone);
			JsonPath jp=rr.jsonPath();
			ID=jp.getString("id");
			System.out.println(ID);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority=2,enabled=false)
	public static void modifyUser()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/users/"+ID;
			RequestSpecification httprequest=RestAssured.given();
			httprequest.header("content-type", "application/json");
			File f3=new File("F:\\GitRepository\\CurrentWorkSpace\\ExampleJuly4th2022Repository\\RestInPeace\\jsonrequest\\modifyuser.json");
			httprequest.body(f3);
			httprequest.header("Authorization",Auth_Token);
			Response resp= httprequest.put();
			String response= resp.asString();
			System.out.println(response);
			JsonPath path=resp.jsonPath();
			ID =path.getString("email");
			System.out.println("remodified   "+ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test(priority=3)
	public static void UserDetails()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/users";
			RequestSpecification httprequest=RestAssured.given();
			httprequest.header("content-type","application/json");
			httprequest.header("Authorization",Auth_Token);
			Response respo=httprequest.get();
			String response=respo.asString();
			System.out.println(response);
			

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority=4,enabled=false)
	public static void deleteuser()
	{
		try 
		{
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/users/"+352169;
			RequestSpecification httprequest=RestAssured.given();
			httprequest.header("content-type","application/json");
			httprequest.header("Authorization",Auth_Token);
			Response res1=httprequest.delete();
			String respone=res1.asString();
			System.out.println(respone);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	@Test(priority=5)
	public static void  signout()
	{
		try 
		{
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/students/sign_out";
			RequestSpecification httprequest=RestAssured.given();
			httprequest.header("content-type","application/json");
			httprequest.header("Authorization",Auth_Token);
		Response rese=httprequest.get();
		String response=rese.asString();
		System.out.println(response);
		
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	

}






