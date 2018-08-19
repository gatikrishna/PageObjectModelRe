package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;

public class ContactsPageTest extends TestBase{

	TestUtils testUtils;
	LoginPage loginPage;
	HomePage  homePage;
	ContactsPage  contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();		
		loginPage = new LoginPage();
		testUtils= new TestUtils();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtils.switchToFrame();
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws IOException {		
		return testUtils.getTestData(sheetName);
	}
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String fname, String lname, String mname) {
		homePage.clickOnNewContactLink();
		contactsPage.fillNewContactForm(title, fname, mname, lname);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
