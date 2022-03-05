package testCases;



import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPagePO;
import utilities.Baseclass;



public class LandingPage extends Baseclass {
	public static Logger log = LogManager.getLogger(LandingPage.class.getName());
	WebDriver driver;
	
	@BeforeTest

	public void driverInitialize() throws IOException {
		
		driver = initializeDriver();
		log.info("Driver initialized");
		driver.get(url);
		log.info("url loaded");
	}
	
	@Test(priority=2)
	
	public void clickoncourses() throws IOException {
		
		LandingPagePO lop = new LandingPagePO(driver);
		lop.getCourses().click();
	
		
		log.info("click on courses is passed");
		
		
	}
	
	@Test(priority=1)
	
	public void verifyText(){
		
		
		LandingPagePO lop1 = new LandingPagePO(driver);
		//Thread.sleep(2000);
		//System.out.println("code working");
		String text = lop1.getTitle().getText();
		//System.out.println(text);
		Assert.assertEquals(text,"FEATURED COURSES");
		//return lop;
		log.info("verify text is passed");
		
	}
	

	@AfterTest
	
	public void tearDown() {
		
		driver.close();
		log.info("driver closed");
	}

	
	
}
