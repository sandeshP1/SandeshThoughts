package com.sgtesting.restapisscenarios;


import java.io.File;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgtesting.restassuredinpeace.SignInPro;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class ApiValidationScenarios {
public static String Auth_token=null;
	
	@Test(priority=1)
	public static void Signin()
	{
		RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/students/sign_in";
		RequestSpecification httprequest=RestAssured.given();
		SignInPro pojo =new SignInPro("Sandeshp8660@gmail.com","gowri@123");
		httprequest.header("content-type","Application/json");
		httprequest.body(pojo);
		
		Response response=httprequest.post();
		String respo1=response.asString();
		System.out.println(respo1);
		
		
		JsonPath jp=response.jsonPath();
		Auth_token=jp.getString("auth_token");
		System.out.println(Auth_token);
		
	}
	@Test(priority=2)
	public static void getUsers()
	{
		try 
		{
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/users";
			RequestSpecification httprequest=RestAssured.given();
			httprequest.header("Content-Type","Application/json");
			httprequest.header("Authorization",Auth_token);
			
			Response response=httprequest.get();
			String text=response.asString();
			System.out.println(text);
			
			List<String> olist=response.jsonPath().getList("$");
			int a=olist.size();
			System.out.println(a);
			
			
////			for(int i=0;i<olist.size();i++)
////			{
////			     if(olist.get(i).contains("karnataka"))
////			     {
//			    	 System.out.println(olist[i]);
////			     }
////			}
			
			
			int code=response.getStatusCode();
			System.out.println(code);
			Assert.assertEquals(200, code);
			
			String statusline=response.getStatusLine();
			System.out.println(statusline);
			Assert.assertEquals("HTTP/1.1 200 OK",statusline);
			
			
			Headers header = response.getHeaders();
			for(Header head:header)
			{
				System.out.println(head);
			}
			Assert.assertEquals("Content-Type", header.getValue("Content-Type"));
			System.out.println("+++++++++++++++++++++++++++++++");
			
			
			String id=given().header("Authorization",Auth_token).when().get().then().assertThat().statusCode(200)
			.body(JsonSchemaValidator.matchesJsonSchema(new File(".\\jsonrequest\\schemademo.json"))).toString();
			System.out.println(id);
			
			String statewhat=httprequest.given().contentType(ContentType.JSON).log().all().when().get("352009").then().extract().path("state").toString();
			System.out.println(statewhat);
			Assert.assertEquals("Andhrapradesh",statewhat);
			
			
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
}
