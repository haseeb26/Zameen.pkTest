package com.zameen.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import com.zameen.qa.base.TestBase;
import com.zameen.qa.pages.ExtraFiltersPage;
import com.zameen.qa.pages.HomePage;
import com.zameen.qa.util.TestUtil;

public class ExtraFiltersPageTest extends TestBase {

	HomePage homePage;
	ExtraFiltersPage extraFilters;
	public String text = "Rome,Italy";
	public int number = 5;
	
	public  ExtraFiltersPageTest() {
		
		super();
	}
	
	//Initialize the Chrome Browser and execute the steps before the Test
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		
		
		intialization();
		 
		//1. Search for properties that match the same filters as the first test.
		homePage = new HomePage();
		extraFilters = new ExtraFiltersPage();
		homePage.selectRome(text);
		homePage.selectDate();
		homePage.selectGuests();
		homePage.clickonSearch();
		
	}
	
		//Test to be executed here
		@Test(priority=1)
		//Test#2: Verify that the results and details page match the extra filters
		public void Test2() throws InterruptedException
		{
			
			extraFilters.clickOnMoreFilters();
			Thread.sleep(1000);
			extraFilters.clickOnBedrooms(number);
			extraFilters.selectPoolFromFacilities();
			extraFilters.clickShowStays();
			extraFilters.numberOfSelectedBedroomsVerification();
			Thread.sleep(4000);

			extraFilters.openDetailsFirstProperty();
			extraFilters.poolIsDisplayed();
		}
		
		//Execute the Steps after the Test is completed
		@AfterMethod
		public void tearDown() {
			//driver.quit();
		}
	
	
	
	
}
