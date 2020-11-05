package com.zameen.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zameen.qa.base.TestBase;
import com.zameen.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	public String text = "Rome,Italy";
	
	public HomePageTest() {
		
		super();
	}
	
	
	//Initialize the Chrome Browser and execute the steps before the Test
	@BeforeMethod
	public void setUp() {
		
		intialization();
		 homePage = new HomePage();
		
	}
	

	// Test to be executed here
	@Test(priority=1)
	//Test#1: Verify that the results match the search criteria
	public void Test1() throws InterruptedException
	{
		homePage.selectRome(text);
		homePage.selectDate();
		homePage.selectGuests();
		homePage.clickonSearch();
		homePage.verificationofAppliedfilters();
		
	}
	
	//Execute the Steps after the Test is completed
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
