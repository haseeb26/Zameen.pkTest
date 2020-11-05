package com.zameen.qa.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.zameen.qa.base.TestBase;

import com.zameen.qa.util.TestUtil;



public class HomePage extends TestBase {
	
	public char day;
	public char day1,day5,mon1,mon2,mon3,dash,day_a,day_b,dash_1,mon_a,mon_b,mon_c;
	public String day_new,veri,mon,s;
	public int int_day,int_month=2,count=0;
	public Calendar cal;
	public String textval = "24";
	public WebElement ci;
	
	//Page Factory - Object Repository:
	@FindBy(xpath= "//input[@id='bigsearch-query-detached-query']")
	WebElement location;
	
	@FindBy(xpath= "//div[contains(text(),'Check in')]")
	WebElement checkin;
	
	@FindBy(xpath= "//body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[4]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/div[1]/div[1]/div[1]")
	WebElement date;
	
	@FindBy(xpath= "//div[contains(text(),'Check out')]")
	WebElement checkout;
	
	@FindBy(xpath= "//div[contains(text(),'Add guests')]")
	WebElement guests;
	
	@FindBy(xpath="//header/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[5]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/button[2]/span[1]/*[1]")
	WebElement adults;
	
	@FindBy(xpath="//header/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[5]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/button[2]/span[1]")
	WebElement adults1;
	
	@FindBy(xpath="//header/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[5]/div[3]/div[1]/section[1]/div[1]/div[1]/div[2]/div[2]/button[2]/span[1]")
	WebElement child;
	
	@FindBy(xpath= "//span[@class='_m9v25n']")
	WebElement search;
	
	@FindBy(xpath= "//button[@data-index='0']//div[@class= '_1g5ss3l']")
	WebElement check_location;
	
	@FindBy(xpath= "//button[@data-index='1']//div[@class='_1g5ss3l']")
	WebElement check_date;
	
	@FindBy(xpath= "//button[@data-index='2']//div[@class='_1g5ss3l']")
	WebElement check_guests;
	
	@FindBy(xpath= "//div[@class = '_1snxcqc']")
	WebElement guests_accomodation;
	
	@FindBy (xpath= "//body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[4]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[5]/td[4]/div[1]/div[1]/div[1]")
	WebElement disable;
	
	
	
	//Initializing the Page Objects:
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	//1. Select Rome,Italy as a location.
	public void selectRome(String text) throws InterruptedException 
	{
			location.sendKeys(text);
			 Thread.sleep(2000);

			 location.click();	
	}
	
	//2. Pick a Check-In date one week after the current date.
	//3. Pick a Check-Out date one week after the Check-In date.
	public void selectDate() throws InterruptedException
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
		 
		checkin.click();
	    Thread.sleep(3000);
	      Date m = new Date();
	      Date m2 = new Date();
	      
	      Calendar cal = Calendar.getInstance();
	      Calendar cal1= Calendar.getInstance();
	      
	      cal.setTime(m);
	      cal1.setTime(m2);
	      
	      cal.add(Calendar.DATE, 7);
	      cal.get(Calendar.DATE);
	      
	      m = cal.getTime();   
	      m2= cal1.getTime();
	      
	      String m1= dateFormat.format(m);
	      String m3= dateFormat.format(m2);

	      
	      //************************for date after 7 days********************88
	      
			 for(int i = 0; i < Math.min(m1.length(), 1); i++)
			 {
				 day =  m1.charAt(i);
			 }
			 
			 for(int i = 1; i < Math.min(m1.length(), 2); i++)
			 {
				 day1 = m1.charAt(i);
			 }
			 
			 for(int i = 2; i < Math.min(m1.length(), 3); i++)
			 {
			     dash = m1.charAt(i);
			 }
			 
			 for(int i = 3; i < Math.min(m1.length(), 4); i++)
			 {
			     mon1 = m1.charAt(i);
			 }
			 
			 for(int i = 4; i < Math.min(m1.length(), 5); i++)
			 {
			     mon2 = m1.charAt(i);
			 }
			 
			 for(int i = 5; i < Math.min(m1.length(), 6); i++)
			 {
			     mon3 = m1.charAt(i);
		     }
			 
			 //****************************current date***********************
			 
			 
			 for(int i = 0; i < Math.min(m3.length(), 1); i++)
			 {
				 day_a =  m3.charAt(i);
			 }
			 
			 for(int i = 1; i < Math.min(m3.length(), 2); i++)
			 {
				 day_b= m3.charAt(i);
			 }
			 
			 for(int i = 2; i < Math.min(m3.length(), 3); i++)
			 {
			     dash_1 = m3.charAt(i);
			 }
			 
			 for(int i = 3; i < Math.min(m3.length(), 4); i++)
			 {
			     mon_a = m3.charAt(i);
			 }
			 
			 for(int i = 4; i < Math.min(m3.length(), 5); i++)
			 {
			     mon_b = m3.charAt(i);
			 }
			 
			 for(int i = 5; i < Math.min(m3.length(), 6); i++)
			 {
			     mon_c = m3.charAt(i);
		     }
			 
			 String big_mon=new StringBuilder().append(day_a).append(day_b).append(dash_1).append(mon_a).append(mon_b).append(mon_c).toString();

			mon = new StringBuilder().append(mon1).append(mon2).append(mon3).toString();

			 
		
			 if(big_mon.equals("23-Oct") || big_mon.equals("24-Oct") || big_mon.equals("25-Oct") || big_mon.equals("26-Oct") || big_mon.equals("27-Oct") || big_mon.equals("28-Oct") || big_mon.equals("29-Oct") || big_mon.equals("30-Oct") || big_mon.equals("31-Oct"))
			 {
				
				 int_month= 3 ;
	
			 }

			 else if(big_mon.equals("23-Nov") || big_mon.equals("24-Nov") || big_mon.equals("25-Nov") || big_mon.equals("26-Nov") || big_mon.equals("27-Nov") || big_mon.equals("28-Nov") || big_mon.equals("29-Nov") || big_mon.equals("30-Nov"))
			 {
				
				 int_month=3;
		
			 }
			 
			 else if(big_mon.equals("23-Dec") || big_mon.equals("24-Dec") || big_mon.equals("25-Dec") || big_mon.equals("26-Dec") || big_mon.equals("27-Dec") || big_mon.equals("28-Dec") || big_mon.equals("29-Dec") || big_mon.equals("30-Dec") || big_mon.equals("31-Dec"))
			 {
				
				 int_month=3;
		
			 }
			 else if(big_mon.equals("23-Jan") || big_mon.equals("24-Jan") || big_mon.equals("25-Jan") || big_mon.equals("26-Jan") || big_mon.equals("27-Jan") || big_mon.equals("28-Jan") || big_mon.equals("29-Jan") || big_mon.equals("30-Jan") || big_mon.equals("31-Jan"))
			 {
				
				 int_month=3;
		
			 }
			 else if(big_mon.equals("23-Feb") || big_mon.equals("24-Feb") || big_mon.equals("25-Feb") || big_mon.equals("26-Feb") || big_mon.equals("27-Feb") || big_mon.equals("28-Feb") || big_mon.equals("29-Feb"))
			 {
				
				 int_month=3;
		
			 }
			 else if(big_mon.equals("23-Mar") || big_mon.equals("24-Mar") || big_mon.equals("25-Mar") || big_mon.equals("26-Mar") || big_mon.equals("27-Mar") || big_mon.equals("28-Mar") || big_mon.equals("29-Mar") || big_mon.equals("30-Mar") || big_mon.equals("Mar"))
			 {
				
				 int_month=3;
		
			 }
			 else if(big_mon.equals("23-Apr") || big_mon.equals("24-Apr") || big_mon.equals("25-Apr") || big_mon.equals("26-Apr") || big_mon.equals("27-Apr") || big_mon.equals("28-Apr") || big_mon.equals("29-Apr") || big_mon.equals("30-Apr"))
			 {
				
				 int_month=3;
		
			 }
			 else if(big_mon.equals("23-May") || big_mon.equals("24-May") || big_mon.equals("25-May") || big_mon.equals("26-May") || big_mon.equals("27-May") || big_mon.equals("28-May") || big_mon.equals("29-May") || big_mon.equals("30-May") || big_mon.equals("31-May"))
			 {
				
				 int_month=3;
		
			 }
			 else if(big_mon.equals("23-Jun") || big_mon.equals("24-Jun") || big_mon.equals("25-Jun") || big_mon.equals("26-Jun") || big_mon.equals("27-Jun") || big_mon.equals("28-Jun") || big_mon.equals("29-Jun") || big_mon.equals("30-Jun"))
			 {
				
				 int_month=3;
		
			 }
			 else if(big_mon.equals("23-Jul") || big_mon.equals("24-Jul") || big_mon.equals("25-Jul") || big_mon.equals("26-Jul") || big_mon.equals("27-Jul") || big_mon.equals("28-Jul") || big_mon.equals("29-Jul") || big_mon.equals("30-Jul") || big_mon.equals("31-Jul"))
			 {
				
				 int_month=3;
		
			 }
			 else if(big_mon.equals("23-Aug") || big_mon.equals("24-Aug") || big_mon.equals("25-Aug") || big_mon.equals("26-Aug") || big_mon.equals("27-Aug") || big_mon.equals("28-Aug") || big_mon.equals("29-Aug") || big_mon.equals("30-Aug") || big_mon.equals("31-Aug"))
			 {
				
				 int_month=3;
		
			 }
			 else if(big_mon.equals("23-Sep") || big_mon.equals("24-Sep") || big_mon.equals("25-Sep") || big_mon.equals("26-Sep") || big_mon.equals("27-Sep") || big_mon.equals("28-Sep") || big_mon.equals("29-Sep") || big_mon.equals("30-Sep"))
			 {
				
				 int_month=3;
		
			 }
			 
			 
	
			 String day4 = new StringBuilder().append(day1).toString();
			 day_new =  new StringBuilder().append(day).append(day1).toString();
		     
		
		     
		     int strint=Integer.parseInt(day_new);
		 
		     
		     int strintnew = strint + 7;
		     s = String.valueOf(strintnew);
		
		     
		     for(int i = 0; i < Math.min(s.length(), 1); i++)
			 {
				  day5 =  s.charAt(i);
				}
		
			 String day6 = new StringBuilder().append(day5).toString();

		    
			 
			 
			 List<WebElement> elements = driver.findElements(By.xpath("//body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[4]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div["+int_month+"]/div[1]/table[1]/tbody[1]/tr/td/div"));

			 for (int i=0; i<elements.size();i++)
		     {
		   
		    	 String hey = elements.get(i).getText();
		         if(hey.equals(day4) && strint < 10)
		         {
		        	 elements.get(i).click();
		    
		    	   
		         }
		       
		        else if(hey.equals(day_new) && strint >= 10)
		       	{
		        	elements.get(i).click();
		   
		    	   
		       	}
		       
		       
		     }


		     for (int i=0; i<elements.size();i++)
		     {
		   
		    	 String hey1 = elements.get(i).getText();
		         if(hey1.equals(day6) && strintnew < 10)
		         {
		        	 elements.get(i).click();
		
		    	   
		         }
		       
		        else if(hey1.equals(s) && strintnew >= 10)
		       	{
		        	elements.get(i).click();
	
		    	   
		       	}
		       
		       
		     }		
	}
	
	//4. Select the number of guests as 2 adults and 1 child.
	public void selectGuests() throws InterruptedException {
		
		guests.click();
		
		//Using Javascript Executor for aria-hidden = true to make it false
		JavascriptExecutor exe_adults = (JavascriptExecutor)driver;
		exe_adults.executeScript("arguments[0].setAttribute('aria-hidden', 'false')", adults);
		adults.click();
		count++;
		JavascriptExecutor exe_adults1 = (JavascriptExecutor)driver;
		exe_adults1.executeScript("arguments[0].setAttribute('aria-hidden', 'false')", adults1);
		adults1.click();
		count++;
		JavascriptExecutor exe_child = (JavascriptExecutor)driver;
		exe_child.executeScript("arguments[0].setAttribute('aria-hidden', 'false')", child);
		child.click();
		count++;

	}
	 
	//5. Search for properties
	public void clickonSearch() {
		
		search.click();
	}
	
	//6. Verify that the applied filters are correct.
	public void verificationofAppliedfilters() throws InterruptedException {
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
		
		// Print the result of 1st Property
		String location = check_location.getText();


		
		if(location.equals("Rome"))
		{
			System.out.println("******************************************************");
			System.out.println("Location is verified");
			System.out.println("******************************************************");
		}
		
		else
		{
			System.out.println("******************************************************");
			System.out.println("Location not verified");
			System.out.println("******************************************************");
			}
		// Print the result of 2nd Property
		String date = check_date.getText();

		
		veri =   new StringBuilder().append(mon).append(" ").append(day_new).append(" ").append("-").append(" ").append(s).toString();

	
		if(date.charAt(0) == veri.charAt(0) && date.charAt(1) == veri.charAt(1) && date.charAt(2) == veri.charAt(2) && date.charAt(4) == veri.charAt(4) && date.charAt(5) == veri.charAt(5)  && date.charAt(9) == veri.charAt(9) && date.charAt(10) == veri.charAt(10))
		{
			System.out.println("******************************************************");
			System.out.println("Date is verified");
			System.out.println("******************************************************");
		}
		
		else
		{
			System.out.println("******************************************************");
			System.out.println("Date not verified");
			System.out.println("******************************************************");
		}

		// Print the result of 3rd Property
		String guests = check_guests.getText();
	
		char gue=(char)(count+'0'); 
		if(gue == guests.charAt(0))
		{
			System.out.println("******************************************************");
			System.out.println("No of guests are verified");
			System.out.println("******************************************************");
		}
		
		else
		{
			System.out.println("******************************************************");
			System.out.println("No of guests are not verified");
			System.out.println("******************************************************");
		}

	}



	
}
