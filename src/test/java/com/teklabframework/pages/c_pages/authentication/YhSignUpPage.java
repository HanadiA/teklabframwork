package com.teklabframework.pages.c_pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YhSignUpPage {

	
	protected WebDriver driver;
    private static String url= "https://login.yahoo.com/account/create";
    
    By firstNameBy = By.id("usernamereg-firstName");
    By lastNameBy = By.xpath("//input[@id='usernamereg-lastName']");
    By policyLinkBy = By.xpath("//a[@class='privacyLink']");
	
    


String expected = "https://www.verizonmedia.com/policies/us/en/verizonmedia/privacy/index.html";
  
  goToSignUpPage();
  enterFirstName("James");
  enterLastName("Howlett");
  clickPolicy();
  switchWindow();
  assertUrl(expected);




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
    
    
	}
	
	
	@Test
	public void policyWindow1() {
		
		
		
		
	}
	 
	private void goTosignupPage() {
		driver.get(url);
	}
	
	private void enterFirstName() {
		WebElement firstName = driver.findElement(By.id("usernamereg-firstName"));
		firstName.sendKeys("James");
		
		WebElement lastName= driver.findElement(By.xpath("//input[@id='usernamereg-lastName']"));
		lastName.sendKeys("Howlett");
		
		WebElement policylink= driver.findElement(By.xpath("//a[class='privacyLink']"));
	
	}

	
}
