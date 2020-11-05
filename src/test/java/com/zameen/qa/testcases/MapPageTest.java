package com.zameen.qa.testcases;

import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zameen.qa.base.TestBase;
import com.zameen.qa.pages.ExtraFiltersPage;
import com.zameen.qa.pages.HomePage;
import com.zameen.qa.pages.MapPage;

public class MapPageTest extends TestBase{

	HomePage homePage;
	ExtraFiltersPage extraFilters;
	MapPage mapPage;
	
	public String text = "Rome,Italy";
	public int number = 5;
	
	public  MapPageTest() {
		
		super();
	}
	
	//Initialize the Chrome Browser and execute the steps before the Test
		@BeforeMethod
		public void setUp() throws InterruptedException {
			
			intialization();
			
			homePage = new HomePage();
			extraFilters = new ExtraFiltersPage();
			mapPage = new MapPage();
			
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
		public void Test3() throws InterruptedException, FindFailed{
			
			
			mapPage.hoverOverTheFirstProperty();
			mapPage.checkPropertyColorChange();
			mapPage.verificationOfResults();
			
			
		}
	
		//Execute the Steps after the Test is completed
		@AfterMethod
		public void tearDown() {
			//driver.quit();
		}
	
	
	
	
	
	
	
	
	
	
	
}
