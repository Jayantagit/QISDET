package com.mapsynq.Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.mapsynq.Base.TestBase;
import com.mapsynq.Utilities.TestUtil;


public class CustomListeners extends TestBase implements ITestListener
{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Case Failed");
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Cpaturing Screenshot");
		log.debug(result.getName().toUpperCase()+"Failed");
		
		try 
		{
			test.fail("Screen Shot : " + test.addScreenCaptureFromPath(TestUtil.captureScreenshot()));
			Reporter.log("<a target=\"_blank\" href="+TestUtil.captureScreenshot()+">Screenshot</a>");
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
			
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		
		log.debug(result.getName().toUpperCase()+" Started");
		test=rep.createTest(result.getName());
		
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
