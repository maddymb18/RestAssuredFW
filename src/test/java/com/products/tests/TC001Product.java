package com.products.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.operations.ApiOperations;

import io.restassured.RestAssured;

public class TC001Product extends TestBase{

	ApiOperations objApiOperations= new ApiOperations();
	
	@BeforeMethod
	public void beforeMethod() {
		
		RestAssured.basePath="/products";
	//	objApiOperations.request();
		//logger= ExtentReport.extent.createTest("TestOne");
		
	}
	
	
	@Test
	public void testOne() {
		
		objApiOperations.jsonResponse();
		int abc = objApiOperations.getStatusCode();
		System.out.println(abc);
	}
	
	
}
