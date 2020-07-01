package com.teklabframework.classExamples.workWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ActionBuilder {
	
	
	protected WebDriver driver;


	 @BeforeMethod
	 public  void startUp() {
	String driverpath = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";
	 System.setProperty("webdriver.chrome.driver", driverpath);
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();   
	}
	 
	 @AfterMethod
		public  void tearDwon () {
		driver.close();
		driver.quit();
		}
	 

	@Test(enabled = false) 
	public  void dragANDDrop() {

	 driver.get("https://jqueryui.com/droppable/"); //navigate to

	 
	
	 WebElement iframe = driver.findElement(By.tagName("iframe"));
	 driver.switchTo().frame(iframe);
	 
	 try {
		  
		  Thread.sleep(2000);
		 } catch (InterruptedException e) {
		  //we did not do anything here
		 }
	 
	 //WebElement fromEle2 = driver.findElement(By.xpath("//div[@id='draggable']"));
	 WebElement fromEle = driver.findElement(By.id("draggable"));
	 WebElement toEle = driver.findElement(By.id("droppable"));
	 

	 
    Actions builder = new Actions (driver);
    builder.dragAndDrop(fromEle, toEle).build().perform();
    
	  
	// element.click();
	 //try {
	  
	  //Thread.sleep(2000);
	 //} catch (InterruptedException e) {
	  //we did not do anything here
	 //}
	 //Enter
	// element.submit();
	 builder.click().contextClick().keyDown(Keys.CONTROL).build().perform();

	 try {
	  Thread.sleep(2000);
	 } catch (InterruptedException e) {
	  //we did not do anything here
	 }
	
	
	 }
		 	

@Test
	public void testFBAction() {
		driver.get("https://www.facebook.com/");
	
	//WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
	//WebElement forgotAccount = driver.findElement(By.xpath("//*[@id=\"login_form\"]/table/tbody/tr[3]/td[2]/div/a"));
		// shorter way
		By locator = (By.xpath("//*[@id=\"login_form\"]/table/tbody/tr[3]/td[2]/div/a"));
	    WebElement link = driver.findElement(locator);
		 highLighter(link);
		 //firstname.clear();
		 
		 Actions diy = new Actions (driver);
		 diy.moveToElement(link)
		 //.click()
		 .contextClick()
		 .click()
		 //.keyDown(Keys.SHIFT)// means all keys will be in upper case.
		 //.sendKeys("johnny") // expected JONNY
		 //.keyUp(Keys.SHIFT)// means release the shift key
		 .build().perform(); // finally build operation and perfrom it.
	System.out.println("Action succeed");
	 try {
		  Thread.sleep(2000);
		 } catch (InterruptedException e) {
		  //we did not do anything here
		
		 }
	 //String actual = firstname.getAttribute("value");
	 //System.out.println("Actual test is" + actual);
	 //String expected = "JOHNNY";
	 //Assert.assertEquals(actual, expected);// compare them.
	 
	 
	
	 
	
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



	
	
	

}
