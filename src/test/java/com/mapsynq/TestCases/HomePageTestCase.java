package com.mapsynq.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mapsynq.Base.TestBase;
import com.mapsynq.Pages.HomePage;

public class HomePageTestCase extends TestBase 
{
	@Test(groups="smoke",description="getDirection")
	public static void GetDirection() 
	{
		
		HomePage homePage = new HomePage();
		homePage.DirectionTab.click();
		wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOf(homePage.StartFrom));
	   	
		homePage.StartFrom.clear();
		homePage.StartFrom.sendKeys(testdata.getProperty("FromLoc"));
		homePage.EndStreetNm.clear();
		homePage.EndStreetNm.sendKeys(testdata.getProperty("ToLoc"));
		homePage.getDirectionBtn.click();
		
		String alertTest=driver.switchTo().alert().getText();
		System.out.println(alertTest);
		if(alertTest != null )
		{
			driver.switchTo().alert().accept();			
		}
		
		Assert.assertFalse(alertTest.contains("We are unable to find the directions"));
		
		
	}	
}
