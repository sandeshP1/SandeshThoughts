package com.sgtesting.restassuredinpeace;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PojoToJsonDemo {

	@Test(priority=1)
	public void jsonObjecDemo()
	{
		try
		{
			SignInPro pojoobj=new SignInPro("heshp@gmail.com","restfulApi");
			ObjectMapper mapper = new ObjectMapper();
			String strjson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojoobj);
			System.out.println(strjson);
			System.out.println("+++++++++++++++++");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority=2)
	public static void jsonObjectDemo1()
	{
		try {
			
			SignInPro pojoobj =new SignInPro();
			pojoobj.setEmail("Whatareth@gmail.com");
			pojoobj.setPassword("Java#123");
			ObjectMapper mapper=new ObjectMapper();
			String strjson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojoobj);
			System.out.println(strjson);
			System.out.println("++++++++++++++++");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 3)
	public static void jsonObjectDemo2()
	{
		try 
		{
			SignInPro pojoobj[]= {new SignInPro("rangann@gmail.com","RestfulApi"),
					new SignInPro("girish@gmail.com","WelCome123"),
					new SignInPro("Ashokkuma@gmail.com","India13"),};
			ObjectMapper mapper =new ObjectMapper();
			String strjson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojoobj);
			System.out.println(strjson);
			System.out.println("++++++++++++++++++");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
