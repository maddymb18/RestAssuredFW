package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.reporting.ExtentReport;
import com.utility.Log;

import io.restassured.RestAssured;

public class TestBase {

	protected static Properties prop;
	protected static ExtentTest logger;
	
	@BeforeSuite
	public void beforeSuite() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
			System.getProperty("user.dir") + "/src/main/java/com/config/config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentReport.initialize();
	}
	
	
	@BeforeTest
	public static void setUp() {
		// test for git
		RestAssured.baseURI = prop.getProperty("uri");
//		if(prop.getProperty("env").equalsIgnoreCase("QA")) {
//			RestAssured.basePath="/products";	
//		}
//		else if(prop.getProperty("env")=="DEV") {
//			RestAssured.basePath="/categories";	
//		}
		
		/*
		 * /stores /services /version /healthcheck
		 */
	}
	
	public static void initalize(String basePath,String testCaseName) {
		
		RestAssured.basePath=basePath;
		logger= ExtentReport.extent.createTest(testCaseName);
		log("Resource URL :" +RestAssured.baseURI+RestAssured.basePath);
		
	}
	
	
	@AfterTest
	public void tearDown() {
		
		ExtentReport.extent.flush();
	}
	
	public static void log(String data) {
		Log.info(data);
		Reporter.log(data);
		logger.log(Status.INFO, data);	
	}
	
	
	
	
	
	
}
