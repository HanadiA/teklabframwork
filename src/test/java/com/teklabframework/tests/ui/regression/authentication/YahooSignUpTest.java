package com.teklabframework.tests.ui.regression.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.teklabframework.pages.c_pages.authentication.YhSignUpPage;

public class YahooSignUpTest {

	
	protected WebDriver driver;
	
	
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
			public void policyWindowTest () {
				 YhSignUpPage
				 
				 p1= new YhSignUpPage();
			 }
	          
	
}
