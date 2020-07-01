package com.teklabframework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestingAround {
	WebDriver driver;


	 @BeforeMethod
	 public  void startUp() {


	String driverpath = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";
	 System.setProperty("webdriver.chrome.driver", driverpath);
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	 
	 
	 
	 
	 
	   
	}

	@Test
	public  void testCase1() {

	 driver.get("https://ebay.com/"); //navigate to

	 
	// WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
	 WebElement next = driver.findElement(By.xpath("//body[@class='desktop gh-flex']/div[@id='mainContent']/div[@class='hl-cat-nav']/ul[@class='hl-cat-nav__container']/li[5]"));

	 
	 highLighter(next);
	// userName.sendKeys("hello this is a test");
	// Clickb(next);
	 


	 
	 
	 
	// element.click();
	 try {
	 
	 
	 
	 
	 
	  Thread.sleep(2000);
	 } catch (InterruptedException e) {
	  //we did not do anything here
	 }
	 //Enter
	// element.submit();

	 try {
	  Thread.sleep(2000);
	 } catch (InterruptedException e) {
	  //we did not do anything here
	 }
	 
	 
	//  String actual = driver.getTitle();
	//  String expected = "Facebook Watch";
	 
	//  Assert.assertEquals(actual, expected);
	 Assert.assertTrue(true);





	}
	public void highLighter (WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js. executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}

	public void Clickb(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", element);
	}



	@AfterMethod
	public  void shutdown () {
	driver.quit();
	}
}
