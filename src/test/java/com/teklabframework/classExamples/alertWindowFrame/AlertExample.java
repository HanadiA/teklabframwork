package com.teklabframework.classExamples.alertWindowFrame;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class AlertExample {

	protected WebDriver driver;

	@BeforeMethod
	public void startUp() {
		String driverpath = System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverpath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDwon() {
		driver.close();
//		driver.quit();
	}

	@Test
	public void alert() {

		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver"); // navigate to
		WebElement ele = driver.findElement(By.xpath("//input[@name='prompt']"));
		ele.click();

		try {
           Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// we did not do anything here
		}

		Alert myalert = driver.switchTo().alert();
		System.out.println(myalert.getText());
		myalert.sendKeys("Hey good day");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();	
		}

		}


//	@Test
	public void alert2() {

		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver"); // navigate to
		WebElement ele = driver.findElement(By.xpath("//input[@name='prompt']"));
		ele.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Alert myalert = driver.switchTo().alert();
		myalert.getText();
		myalert.sendKeys("Hiall");
		myalert.accept();
		myalert.dismiss();
	

		//acceptAlert();
		Assert.assertTrue(true);
	}

	// --------------------customized helper method to accept alert----------------------------------------

	//public void acceptAlert() {
		//Alert alert1 = driver.switchTo().alert();
		//alert1.accept();
		// to make it shorter..
		//driver.switchTo().alert().accept();
	//}
 // also you can use it two different methods:
	//public Alert switchToAlert() { // it will return alert object.
		//return driver.switchTo().alert();
	//}
	
	//public void OkAlert() {
		//switchToAlert().accept(); // we are using this method to call the previous method switchToAlert
	//}

}
