package com.zameen.qa.pages;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zameen.qa.base.TestBase;
import com.zameen.qa.util.TestUtil;
import com.zameen.qa.base.TestBase;

public class ExtraFiltersPage extends TestBase{

	//Page Factory - Object Repository:
	@FindBy(xpath= "//div[@id='menuItemButton-dynamicMoreFilters']")
	WebElement more_filters;
	
	@FindBy(xpath= "//button[@data-testid='filterItem-rooms_and_beds-stepper-min_bedrooms-0-increase-button']")
	WebElement bedrooms;
	
	@FindBy(xpath= "//label[@data-testid='filterItem-facilities-checkbox-amenities-7']")
	WebElement pool;
	
	@FindBy(xpath= "//button[@data-testid='more-filters-modal-submit-button']")
	WebElement show_stays;
	
	@FindBy(xpath= "//div[@class='_kqh46o']")
	WebElement verify_bedrooms;
	
	@FindBy(xpath= "//div[@class='_ttw0d']")
	WebElement first_prop;
	
	@FindBy(xpath= "//span[@class='_14tkmhr']")
	WebElement share;
	
	@FindBy(xpath= "//h2[@class='_14i3z6h']")
	WebElement amenities;
	
	@FindBy(xpath= "//div[contains(text(),'Pool')]")
	WebElement verify_pool;
	
	//Initializing the Page Objects:
		public ExtraFiltersPage() {
			
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		
		//2. Click More filters
		public void clickOnMoreFilters() {
			
			// Wait for the page to load 
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			// Implicit wait 
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
			more_filters.click();
		}
		
		//3. Select the number of bedrooms as 5
		public void clickOnBedrooms(int number) throws InterruptedException {
		
			// Scroll into the view of Bedrooms throgh Javascript Executor
			JavascriptExecutor je = (JavascriptExecutor)driver;
			je.executeScript("arguments[0].scrollIntoView(true);",bedrooms);
			
			//Using Javascript Executor for aria-hidden = true to make it false
			je.executeScript("arguments[0].setAttribute('aria-hidden', 'false')", bedrooms);
			
			
			// Click on bedrooms 5 times
			
			for(int i=0; i<=4; i++) {
			
				
				bedrooms.click();
			}
		}
		
		//4. Select Pool from the Facilities section.
		public void selectPoolFromFacilities() {
			
			// Scroll into the view of Bedrooms throgh Javascript Executor
			JavascriptExecutor je = (JavascriptExecutor)driver;
			je.executeScript("arguments[0].scrollIntoView(true);",pool);
			
			// Click on Pool Checkbox
			pool.click();
		}
		
		//5. Click Show Stays
		public void clickShowStays() {
			
			show_stays.click();
		}
		
		//6. Verify that the properties displayed on the first page have at least the number of selected bedroom.
		public void numberOfSelectedBedroomsVerification() {
			
			// Wait for the page to load 
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			// Implicit wait 
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
			
			String prop_text = verify_bedrooms.getText();
			System.out.println("The verification for bedrooms is below");

			System.out.println(prop_text);
			
			System.out.println("============================================");
		}
		
		//7. Open the details of the first property.
		public void openDetailsFirstProperty() throws InterruptedException {
			
			// Wait for the page to load 
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			// Implicit wait 
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
			
			//Click on the first property
			first_prop.click();
		}
		
		//8. Check that in the Amenities popup Pool is displayed under Facilities category.
		public void poolIsDisplayed() throws InterruptedException  {
			
			// Wait for the page to load 
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			// Implicit wait 
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
			
			//Switch to the new tab using Handlers
			
			 Set <String> windowHandles = driver.getWindowHandles();

			    for(String winHandle : driver.getWindowHandles()){

			        driver.switchTo().window(winHandle);
			
			// Scroll into the view of Amenities throgh Javascript Executor
			JavascriptExecutor je = (JavascriptExecutor)driver;
			je.executeScript("arguments[0].scrollIntoView(true);",share);
			
		}
		
				Thread.sleep(2000);
				JavascriptExecutor je = (JavascriptExecutor)driver;
				je.executeScript("arguments[0].scrollIntoView(true);",amenities);
		
			// Get the text "Pool" under the Categories from Aminities Popup
				String pool_text = verify_pool.getText();
				System.out.println(pool_text);
				
				if(pool_text.equals("Pool")) {
					
					System.out.println("Pool is displayed under Facilities category and it is verified");
					System.out.println("============================================");

				}
				
				else {
					
					System.out.println("Pool is not displayed under Facilities category and it is not verified");
					System.out.println("============================================");

				}
				
				
		
		}}
