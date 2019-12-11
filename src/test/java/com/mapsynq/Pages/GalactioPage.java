package com.mapsynq.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mapsynq.Base.TestBase;

public class GalactioPage extends TestBase
{
	@FindBy(xpath="//a[contains(text(),'About')]") public WebElement AboutLnk;
	
	public GalactioPage() 
	{
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}

}
