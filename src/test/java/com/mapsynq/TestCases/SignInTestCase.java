package com.mapsynq.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mapsynq.Base.TestBase;
import com.mapsynq.Pages.HomePage;
import com.mapsynq.Pages.RegisterPage;
import com.mapsynq.Pages.SignInPage;



public class SignInTestCase extends TestBase
{
	
	@Test(priority=0,groups="smoke",description="Validate SignIn Page Title")
	public static void validatePageTitle() {
		
		HomePage homePage = new HomePage();
		SignInPage signInPage=new SignInPage();
		homePage.SignInLnk.click();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("PageLoadTime")), TimeUnit.SECONDS);
	   	wait.until(ExpectedConditions.visibilityOf(signInPage.UserName));
	    String actualTitle=signInPage.getPageTitle();
	    String expectedTitle=testdata.getProperty("SignInPageTitle");		
		Assert.assertEquals(actualTitle,expectedTitle);		
	}
	
	@Test(priority=1,groups="smoke",description="Invalid SignIn")
	public static void InvalidSignIn() 
	{
		SignInPage signInPage=new SignInPage();		
		signInPage.doSignIn(testdata.getProperty("invalidUserName"), testdata.getProperty("InvalidPassword"));
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Invalid')]")).getText(),"Invalid user/password combination");		
	}
	
	@Test(priority=2,groups="smoke",description="CreateAcctLinkCheck")
	public static void CreateAcctLinkCheck() 
	{
		SignInPage signInPage=new SignInPage();
		signInPage.CreateAcctLnk.click();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("PageLoadTime")), TimeUnit.SECONDS);
		RegisterPage registerPage=new RegisterPage();
		
		//Validate that it is Redirecting to Register Page
		
		Assert.assertNotNull(registerPage.RegisterPageHeading);	
		
	}
	

}
