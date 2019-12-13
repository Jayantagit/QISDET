package com.mapsynq.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mapsynq.Base.TestBase;

public class SignInPage extends TestBase 
{
	@FindBy(id="name") public WebElement UserName;
	@FindBy(id="password") public WebElement Password;
	@FindBy(xpath="//input[@value='Sign In']") public WebElement SignInBtn;
	@FindBy(xpath="//a[contains(text(),'Create Account')]") public WebElement CreateAcctLnk;
	
		
	public SignInPage() {
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}
	
	//=========================Page Actions================================
	
	public void doSignIn(String uname,String password)
	{
		UserName.sendKeys(uname);
		Password.sendKeys(password);
		SignInBtn.click();
	}
	
	//-----------------Overloading Method-----------------------------------
	public void doSignIn()
	{
		UserName.sendKeys("");
		Password.sendKeys("");
		SignInBtn.click();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
		
	}
	
}
