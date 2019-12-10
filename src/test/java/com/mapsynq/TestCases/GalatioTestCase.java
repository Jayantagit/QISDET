package com.mapsynq.TestCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mapsynq.Base.TestBase;
import com.mapsynq.Pages.HomePage;
import com.mapsynq.Pages.SignInPage;

public class GalatioTestCase extends TestBase
{
	
	@Test(groups="smoke",description="Successful Galactio Launched")
	public static void GalactioLaunch() 
	{
		
		HomePage homePage = new HomePage();
		homePage.GalactioLnk.click();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("PageLoadTime")), TimeUnit.SECONDS);
	   	driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("ImplicitTime")), TimeUnit.SECONDS);
	    
        String currentHandle= driver.getWindowHandle();
	    Set<String> handles=driver.getWindowHandles();
	        for(String actual: handles)
	        {
	         if(!actual.equalsIgnoreCase(currentHandle))
	         {
	             driver.switchTo().window(actual);
	         }	
	       }
	        
	      Assert.assertTrue(driver.getTitle().equals("Galactio"));  

        }
}	
