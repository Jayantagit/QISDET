package com.mapsynq.TestCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mapsynq.Base.TestBase;
import com.mapsynq.Pages.HomePage;

public class GPSNavigationTestCase extends TestBase
{
	
	@Test(groups="smoke",description="Successful GPSNavigation Launched")
	public static void GPSNavigationLaunch() 
	{
		
		HomePage homePage = new HomePage();
		homePage.NavigationoLnk.click();
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
	        
	      Assert.assertTrue(driver.getCurrentUrl().contains("https://play.google.com/"));  

        }

}
