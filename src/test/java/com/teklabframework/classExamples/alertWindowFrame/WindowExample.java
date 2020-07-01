package com.teklabframework.classExamples.alertWindowFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;


public class WindowExample {

	
	protected WebDriver driver;

	


	 @BeforeMethod
	 public  void startUp() {

	String driverpath = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";
	 System.setProperty("webdriver.chrome.driver", driverpath);
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	   
	 }
	 
	 @AfterMethod
		public  void teardown () {
		 driver.close();
		driver.quit();
		}

	@Test
	public  void policyWindow() {

	 driver.get("https://login.yahoo.com/account/create"); //navigate to
     String orginWindow = driver.getWindowHandle(); // to show our driver which window to focus on.
     System.out.println("Driver's currrent window" + orginWindow); // in the console will show the widow handle ID #.
     
     
	WebElement policyLink = driver.findElement(By.xpath("//a[@class='privacyLink']"));
	 policyLink.click();
	 
	 try {
	  Thread.sleep(2000);
	 } catch (InterruptedException e) {
		 e.printStackTrace();
	  }
	System.out.println("current webpage title: " + driver.getTitle()); // here the dirver focus still on the origin window wich is yahoo
	
	// String s1= driver.getWindowHandle(); if 
	//System.out.println("Driver's current window: " +s1);
    
	
	Set<String> handles = driver.getWindowHandles(); // it returns all window id to us.
	System.out.println(handles);
	String targetWinID =null;// declare targetWinID to find the target window id.  why you put null value there?
	
	
	
	for( String ele: handles) { 
		if (!orginWindow.equalsIgnoreCase(ele)) { // compare every element in the handle to orginwindow to switch to the new window. it help us to locate the window element we want to open. 
			targetWinID= ele;// assign ele this to targetwindowID,
			driver.switchTo().window(ele); // if it is not the same then switch to the targetwindow id.
			System.out.println("Suceesfully switched!!  /n Now current webTitle is:  " + driver.getTitle()); // get the new Title of new window
			
			break; // when switch to new window break the for loop.
			
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------  
	//another way to switch to new window by using Iterator ( we use iterator and hashmap to for long list of arrays.
	//Iterator<String> iter = handles.iterator();
	//while(iter.hasNext()) {
		//String childWindow = iter.next();
		
		
		//if (!orginWindow.equalsIgnoreCase(childWindow)) {
			//driver.switchTo().window(childWindow);
			//System.out.println("Now current webTitle is : " + driver.getTitle());
			
			//break;
		//}

	
	
	WebElement brandBtn = driver.findElement(By.xpath("//a[contains(text(),'brands')]")); // find the brand icon in the Window and click it.
	brandBtn.click();
	
	
	
	 try {
		 
		 
		  Thread.sleep(2000);
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		  }
			
	 Assert.assertTrue(true);

//-------------------------------------------------------------------------------------------------------------------------------------------
	// a way to switch back to our Yahoo window is the origin one.
	 driver.switchTo().window(orginWindow);
	 policyLink.click();
	 driver.switchTo().window(targetWinID);
	
	
	 try {
		 
		  Thread.sleep(2000);
		 } catch (InterruptedException e1) {
			 e1.printStackTrace();
		  }
			
	 Assert.assertTrue(true);


		
	 }
	
	
	
	
	
	}



	

	

