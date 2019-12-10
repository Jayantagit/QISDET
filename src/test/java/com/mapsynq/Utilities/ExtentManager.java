package com.mapsynq.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager 
{
	
	//Build a new report using the Extent HTML template 
	private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
        	
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\target\\surefire-reports\\"+"Extent.html");
			extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
		}
		return extent;
	}

}
