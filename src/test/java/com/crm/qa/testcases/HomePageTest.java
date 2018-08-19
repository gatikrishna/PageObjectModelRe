package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;

public class HomePageTest extends TestBase{
	
	TestUtils testUtils;
	LoginPage loginPage;
	HomePage  homePage;
	ContactsPage  contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();		
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		assertEquals("CRMPRO", title);
	}

	@Test(priority = 2)
	public void clickContactsTab() {
		testUtils = new TestUtils();
		testUtils.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

