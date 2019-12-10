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
		
	public SignInPage() {
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}
	
}
