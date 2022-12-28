package com.sgtesting.restAssuredCompany;

import org.testng.annotations.Test;

import com.sgtesting.restassuredinpeace.CreateUsersScenario;
import com.sgtesting.restassuredinpeace.SignInPro;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SiginCompany {
	public static String Auth_Token=null;
	public static String Creat_Company_ID=null;
	
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
	public static void createCompany()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/companies";
			RequestSpecification httprequest=RestAssured.given();
			ComapanyScenario pojocreate=new ComapanyScenario("lohitBors","Lohitbro@gmail.com","kayithimnahaalii","7418529630");
			httprequest.header("content-type","Application/json");			
			httprequest.body(pojocreate);
			httprequest.header("Authorization",Auth_Token);
			Response rr=httprequest.post();
			String response=rr.asString();
			System.out.println(response);
			JsonPath json=rr.jsonPath();
			Creat_Company_ID=json.getString("id");
			System.out.println(Creat_Company_ID);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority=3,enabled=false)
	public static void editCompany()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/companies/"+Creat_Company_ID;
			RequestSpecification httprequest=RestAssured.given();
			ComapanyScenario pojocreate=new ComapanyScenario("lohitBorsremodified","Lohitbro@gmail.com","kayithimnahaalii","7418529630");
			httprequest.header("content-type","Application/json");			
			httprequest.body(pojocreate);
			httprequest.header("Authorization",Auth_Token);
			Response rr=httprequest.put();
			String response=rr.asString();
			System.out.println(response);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority=4,enabled=true)
	public static void getAllCompany()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/companies";
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
	@Test(priority=5,enabled=true)
	public static void getsingleCompany()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/companies/"+"24289";
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
	
	@Test(priority=6,enabled=true)
	public static void deleteCompany()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/companies/"+"24289";
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
}
