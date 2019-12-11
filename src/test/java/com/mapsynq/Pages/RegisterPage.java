package com.mapsynq.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mapsynq.Base.TestBase;

public class RegisterPage extends TestBase 
{
    
	@FindBy(id="profile_first_name") public WebElement profileFirstName;
	@FindBy(id="profile_last_name") public WebElement profileLasttName;
	@FindBy(id="profile_country") public WebElement profileCountry; //Select dropdown
	@FindBy(id="profile_address") public WebElement profileAddress;
	@FindBy(id="profile_contact_no") public WebElement profileContactNo;
	@FindBy(id="profile_gender_M") public WebElement profileMaleoption;
	@FindBy(id="profile_gender_F") public WebElement profileFeMaleoption;
	@FindBy(id="profile_dob") public WebElement profileDob;
	@FindBy(id="profile_email") public WebElement profileEmail;
	@FindBy(id="password") public WebElement profilePassword;
	@FindBy(id="identity[password_confirmation]") public WebElement profileConfPassword;
	@FindBy(id="chk_agree") public WebElement profileAgree;
	@FindBy(xpath="//input[@value='Create Profile']") public WebElement createProfilebtn;
	@FindBy(xpath="//div[@class='error_signup']']") public WebElement errorMsg;
	
			
	
	
		
	public RegisterPage() {
		PageFactory.initElements(driver, this);
		log.debug("HomePage Initialized.");
	}
}
