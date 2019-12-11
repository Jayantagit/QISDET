package com.mapsynq.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mapsynq.Base.TestBase;

public class HomePage extends TestBase
{

	@FindBy(xpath="//a[text()='Sign in']") public WebElement SignInLnk;
	//@FindBy(xpath="//a[text()='Register ']") public WebElement RegisterLnk;
	@FindBy(xpath="//a[contains(text(),'Register')]") public WebElement RegisterLnk;
	@FindBy(xpath="//a[text()='Mobile App']") public WebElement MobileAppLnk;
	@FindBy(xpath="//a[text()='Galactio']") public WebElement GalactioLnk;
	@FindBy(xpath="//a[text()='SG GPS Navigation']") public WebElement NavigationoLnk;
		
	public HomePage() {
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}
	
	
}
