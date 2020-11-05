 package com.zameen.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.ImagePath;

import com.zameen.qa.pages.MapPage;
import com.zameen.qa.util.TestUtil;





public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() {
		
		
		
		try {
			
			prop = new Properties();
			
			
			FileInputStream ip = new FileInputStream("C:\\Users\\Zubair\\Pictures\\Zameen.pkTest\\src\\main\\java\\com\\zameen\\qa\\config\\config.properties");
			prop.load(ip);
				
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}	
		
	}
	
	
	public static void intialization() {
		
		String browserName = prop.getProperty("browser");
		
		// Set the Properties for Chrome browser
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zubair\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		driver.manage().window().maximize(); // Maximize the browser Window
		driver.manage().deleteAllCookies(); // Delete all the Cookies
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); // Wait for the page to load
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); // Implicit wait 
		
		driver.get(prop.getProperty("url")); // Hit the URL
	}



}


	