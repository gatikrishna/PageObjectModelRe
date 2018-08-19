package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(name="title")
	WebElement title;
	
	@FindBy(name="first_name")
	WebElement fname;
	
	@FindBy(name="middle_initial")
	WebElement mname;
	
	@FindBy(name="surname")
	WebElement lname;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement save;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void fillNewContactForm(String strTitle, String strFname,String strMname, String strLname) {
		
		Select select = new Select(title);
		select.selectByVisibleText(strTitle);
		fname.sendKeys(strFname);
		mname.sendKeys(strMname);
		lname.sendKeys(strLname);
		save.click();
		
	}
	
}
