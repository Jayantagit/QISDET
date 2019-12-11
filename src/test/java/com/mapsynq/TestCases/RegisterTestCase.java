package com.mapsynq.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.mapsynq.Base.TestBase;
import com.mapsynq.Pages.HomePage;
import com.mapsynq.Pages.RegisterPage;
import com.mapsynq.Utilities.TestUtil;


public class RegisterTestCase extends TestBase 
{
	
	@Test(groups="smoke",description="Registeration")
	public static void Registration() 
	{
		
		HomePage homePage = new HomePage();
		RegisterPage registerPage=new RegisterPage();
		homePage.RegisterLnk.click();
		wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOf(registerPage.profileFirstName));
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("PageLoadTime")), TimeUnit.SECONDS);
	   
	   	
	    //-------------Enter the First Name
	   	registerPage.profileFirstName.sendKeys(testdata.getProperty("FirstName"));
	   	
	  //-------------Enter the Last Name	   	
	   	registerPage.profileLasttName.sendKeys(testdata.getProperty("LastName"));
	   	
	    //-------------Select the Country   	
	   	new Select(registerPage.profileCountry).selectByVisibleText(testdata.getProperty("Country"));
	   	
	    //-------------Enter the Address  	
	   	registerPage.profileAddress.sendKeys(testdata.getProperty("Address"));
	   	
	    //-------------Enter the Contact  	
	   	registerPage.profileContactNo.sendKeys(testdata.getProperty("Contact"));
	   	
	   	//-------------Select the Gender
	   	
	   	if (testdata.getProperty("Gender").equalsIgnoreCase("Male"))
	   	{
	   		registerPage.profileFeMaleoption.click();
	   	}
	   	else if(testdata.getProperty("Gender").equalsIgnoreCase("Female"))
	   	{
	   		registerPage.profileFeMaleoption.click();
	   	}
	   	
	  //-------------Enter the Email Address
	   	registerPage.profileEmail.sendKeys(testdata.getProperty("Email"));
	   	
	  //-------------Enter the Dob
	   	TestUtil.selectDate(registerPage.profileDob,testdata.getProperty("DOB"));
	   	
	  //-------------Enter the Password	   	
	   	registerPage.profilePassword.sendKeys(testdata.getProperty("Password"));
	   	
	  //-------------Enter the Confirm Password	   	
	   	registerPage.profilePassword.sendKeys(testdata.getProperty("Confpassword"));
	   	
	 //------------Click the I Agree Checkbox
	   	registerPage.profileAgree.click();
	   	
	  //------------Click the Create Profile Button
		registerPage.createProfilebtn.click();
		
		/*		
		wait = new WebDriverWait (driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='header_notification_msg']")));
	    
	    */
	   		   	
	    Assert.assertNull(registerPage.errorMsg);
	   	
	  
	}

}
