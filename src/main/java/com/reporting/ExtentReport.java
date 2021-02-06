package com.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReport 
{
	public static ExtentSparkReporter reporter=null;
	public static ExtentReports extent=null;

	//private constructor to limit initialization to one
	private ExtentReport()
	{
		reporter=new ExtentSparkReporter("./Reports/Report.html");
	
		reporter.config().setDocumentTitle("RestAssured Automation Report");
		reporter.config().setReportName("RestAssured Execution");
		reporter.config().setTheme(Theme.DARK);
		
		
        // Create object of ExtentReports class- This is main class which will create report
		extent = new ExtentReports();
		extent.setSystemInfo("Environment", "Automation");
		extent.setSystemInfo("Created By", "Madhur Bharadwaj");
    
        // attach the reporter which we created in Step 1
		extent.attachReporter(reporter);
		
	    // call createTest method and pass the name of TestCase- Based on your requirement
	    
	    
            // log method will add logs in report and provide the log steps which will come in report
	   
		
	
	}
	//Initializes Report
	public static void initialize()
	{
		@SuppressWarnings("unused")
		ExtentReport report=new ExtentReport();
	}
}
