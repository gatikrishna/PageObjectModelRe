package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement login;
	
	@FindBy(xpath="//div[@class='navbar-header']//img[@class='img-responsive']")
	WebElement crmLogo;
	
	@FindBy(xpath="//div[@id='navbar-collapse']//li[2]/a")
	WebElement signUp;
	
	//Initializing page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String paswd) {
		username.sendKeys(un);
		password.sendKeys(paswd);
		login.click();
		
		return new HomePage();
	}
	
}
