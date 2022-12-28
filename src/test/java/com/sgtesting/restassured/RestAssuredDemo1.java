package com.sgtesting.restassured;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredDemo1 {
	public static String Auth_Token=null;
	public static String Id=null;
@Test(priority=1)
public static void Signin()
{
	try {
		
		RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/students/sign_in";
		
		RequestSpecification httprequest=RestAssured.given();
		httprequest.header("Content-Type","application/json");
		File f1=new File("F:\\GitRepository\\CurrentWorkSpace\\ExampleJuly4th2022Repository\\RestInPeace\\jsonrequest\\signin.json");
		httprequest.body(f1);
		
		Response rr=httprequest.post();
		String respon=rr.asString();
		System.out.println(respon);
		JsonPath jp=rr.jsonPath();
		Auth_Token=jp.getString("auth_token");
		System.out.println(Auth_Token);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
@Test(priority=2)
public static void CreateUser()
{
	try {
		
		RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/users";
		
		RequestSpecification httprequest=RestAssured.given();
		httprequest.header("Content-Type","application/json");
		File f1=new File("F:\\GitRepository\\CurrentWorkSpace\\ExampleJuly4th2022Repository\\RestInPeace\\jsonrequest\\CreateUser.json");
		httprequest.body(f1);
		httprequest.header("Authorization",Auth_Token);
		
		Response rr=httprequest.post();
		String respon=rr.asString();
		System.out.println(respon);
		JsonPath jp=rr.jsonPath();
		Id=jp.getString("id");
		System.out.println(Id);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

@Test(priority=3)
public static void Modifyuser()

{
	try {
		
		RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/users/"+Id;
		
		RequestSpecification httprequest=RestAssured.given();
		httprequest.header("Content-Type","application/json");
		File f1=new File(".\\jsonrequest\\modify.json");
		httprequest.body(f1);
		httprequest.header("Authorization",Auth_Token);
		
		Response rr=httprequest.put();
		String respon=rr.asString();
		System.out.println(respon);
		//JsonPath jp=rr.jsonPath();
//		Id=jp.getString("id");
//		System.out.println(Id);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
