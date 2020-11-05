package com.zameen.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.zameen.qa.base.TestBase;

import com.zameen.qa.util.TestUtil;

public class MapPage extends TestBase {
	
	

	//Page Factory - Object Repository:
	@FindBy(xpath= "//div[@class='_ttw0d']")
	WebElement first_prop;
	
	@FindBy(xpath= "//span[@class='_1p7iugi']")
	WebElement prop_on_the_screen;
	
	@FindBy(xpath= "//div[@class='_mvzr1f2']//span[@class='_1p7iugi']")
	WebElement prop_on_the_map;
	
	Screen color_change; 
	
		
		
		//Initializing the Page Objects:
		public MapPage() {
					
			
			PageFactory.initElements(driver, this);
		
		}
			
		
		//Actions:
		
		//2. Hover over the first property
		public void hoverOverTheFirstProperty() throws InterruptedException {
			
			// Wait for the page to load 
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			// Implicit wait 
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
			Thread.sleep(2000);
			Actions builder = new Actions(driver);
			builder.moveToElement(first_prop).build().perform();
		}
			
		//3. Check that the property is displayed on the map and the color changes to indicate the selection.	
		
		public void checkPropertyColorChange() throws FindFailed, InterruptedException   {
			
			// Create the object of Screen class - sikuli
			
			 color_change = new Screen();
			
			 // Check that the cross is displayed on the Map
			Pattern cross_img = new Pattern("C:\\Users\\Zubair\\Pictures\\Zameen.pkTest\\cross.png");
			color_change.wait(cross_img,2000);
			color_change.click();
			Thread.sleep(1000);
			hoverOverTheFirstProperty();
			
			
			 // Check that the property is displayed on the Map
			Pattern prop_img = 	new  Pattern("C:\\Users\\Zubair\\Pictures\\Zameen.pkTest\\dollar.png");
			color_change.wait(prop_img,5000);
			
			//4. After identifying the property on the map, click it.
			color_change.click();
			
			
			
		}
		
		//5. Verify that the details shown in the map popup are the same as the ones shown in the search results.
		public void verificationOfResults(){
			
			String text_on_the_screen = prop_on_the_screen.getText();
			System.out.println(text_on_the_screen);
			
			String text_on_the_map = prop_on_the_map.getText();
			System.out.println(text_on_the_map);
			
			
			if(text_on_the_screen.equals(text_on_the_map)) {
				
				System.out.println("The details shown in the map popup are the same as the ones shown in the search results");

			}
			
			else {
				
				System.out.println("The details shown in the map popup are the not same as the ones shown in the search results");
			}
		}
			
			
			
			
			
			
			
			
			
}
