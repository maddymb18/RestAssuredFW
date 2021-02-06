package com.services.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.operations.ApiOperations;

public class TC001Categories extends TestBase{

	ApiOperations objApiOperations= new ApiOperations();
	
	@BeforeMethod
	public void beforeMethod() {
		initalize("/categories", "TC001Categories");
	}
	
	
	@Test
	public void testOne() {
		
		objApiOperations.jsonResponse();
		int abc = objApiOperations.getStatusCode();
		System.out.println(abc);
	}
	
	
}
