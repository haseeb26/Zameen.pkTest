package com.zameen.qa.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class youtube {

	public static void main(String[] args) throws FindFailed {
		// TODO Auto-generated method stub
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zubair\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); // Maximize the browser Window
		driver.manage().deleteAllCookies(); // Delete all the Cookies
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // Wait for the page to load
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait 
		
		driver.get("https://www.youtube.com/watch?v=OtQAMoXYqes"); // Hit the URL	

		Screen s = new Screen();
		
		Pattern pauseImg = new Pattern("C:\\Users\\Zubair\\Documents\\play.png");
		s.wait(pauseImg,4000);
		s.click();
		
		
		
		
	}

}
