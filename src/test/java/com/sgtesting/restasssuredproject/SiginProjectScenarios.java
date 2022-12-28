package com.sgtesting.restasssuredproject;

import org.testng.annotations.Test;

import com.sgtesting.restAssuredCompany.ComapanyScenario;
import com.sgtesting.restassuredinpeace.SignInPro;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SiginProjectScenarios {
	public static String Auth_Token=null;
	public static String Creat_project_ID=null;
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
			System.out.println("+++++++++++++++++++++++");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority=2,enabled=false)
	public static void createPoject()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/projects";
			RequestSpecification httprequest=RestAssured.given();
			PojoCompanyScenariosc pojocreate=new PojoCompanyScenariosc("missionIt","4","24/12/2020","24/12/2021","CompnayBusiness","21369");
			httprequest.header("content-type","Application/json");			
			httprequest.body(pojocreate);
			httprequest.header("Authorization",Auth_Token);
			Response rr=httprequest.post();
			String response=rr.asString();
			System.out.println(response);
			JsonPath json=rr.jsonPath();
			Creat_project_ID=json.getString("id");
			System.out.println(Creat_project_ID);
			System.out.println("+++++++++++++++++++++++++");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority=3,enabled=false)
	public static void modifyProject()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/projects/"+Creat_project_ID;
			RequestSpecification httprequest=RestAssured.given();
			PojoCompanyScenariosc pojocreate=new PojoCompanyScenariosc("missionRemodifiedIt","4","24/12/2020","24/12/2021","CompnayBusiness","21369");
			httprequest.header("content-type","Application/json");			
			httprequest.body(pojocreate);
			httprequest.header("Authorization",Auth_Token);
			Response rr=httprequest.put();
			String response=rr.asString();
			System.out.println(response);
			JsonPath json=rr.jsonPath();
			Creat_project_ID=json.getString("id");
			System.out.println(Creat_project_ID);
			System.out.println("++++++++++++++++++++++++");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority=4,enabled=true)
	public static void getProjects()
	{
		try 
		{
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/projects";
			RequestSpecification httprequest=RestAssured.given();
			httprequest.header("content-type","application/json");
			httprequest.header("Authorization",Auth_Token);
			Response resp=httprequest.get();
			String response=resp.asString();
			System.out.println(response);
			System.out.println("++++++++++++++++");


		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority=7,enabled=true)
	public static void getSingleProject()
	{
		try 
		{
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/projects/"+"11189";
			RequestSpecification httprequest=RestAssured.given();
			httprequest.header("content-type","application/json");
			httprequest.header("Authorization",Auth_Token);
			Response re=httprequest.get();
			String response=re.asString();
			System.out.println(response);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority=6,enabled=true)
	public static void deleteScenario()
	{
		try 
		{
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/projects/"+"11189";
			RequestSpecification httpheader=RestAssured.given();
			httpheader.header("content-type","application/json");
			httpheader.header("Authorization",Auth_Token);
			Response rr=httpheader.delete();
			String response=rr.asString();
			System.out.println(response);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
