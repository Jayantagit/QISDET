package com.mapsynq.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mapsynq.Base.TestBase;
import com.mapsynq.Pages.HomePage;
import com.mapsynq.Pages.SignInPage;



public class SignInTestCase extends TestBase
{
	
	@Test(groups="smoke",description="Invalid SignIn")
	public static void InvalidSignIn() {
		
		HomePage homePage = new HomePage();
		SignInPage signInPage=new SignInPage();
		homePage.SignInLnk.click();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("PageLoadTime")), TimeUnit.SECONDS);
	   	driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("ImplicitTime")), TimeUnit.SECONDS);
	  
		
		signInPage.UserName.sendKeys(testdata.getProperty("invalidUserName"));
		signInPage.Password.sendKeys(testdata.getProperty("InvalidPassword"));
		signInPage.SignInBtn.click();
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Invalid')]")).getText(),"Invalid user/password combination");		
	}
	

}
