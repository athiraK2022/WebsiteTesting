package testCases;

import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CoursesPO;
import utilities.Baseclass;

public class CoursesPage extends Baseclass {
	
	WebDriver driver;
	public static Logger log = LogManager.getLogger(CoursesPage.class.getName());
	
	@BeforeTest
	
	public void driverInitilization() throws IOException {
		
		driver = initializeDriver();
		log.info("driver initialized");
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		log.info("url loaded");
		
	}
	
	@Test
	
	public void clickOnRadioButton() throws IOException {
		
		
		CoursesPO cpo = new CoursesPO(driver);
		cpo.getRadiobutton().click();
		
		//CoursesPO button = new CoursesPO(driver);
		//button.getRadiobutton();
		log.info("click on radio button passed");
		
	}
	
	@AfterTest
	
	public void TearDown() {
		
		driver.close();
		log.info("driver closed");
	}

}
