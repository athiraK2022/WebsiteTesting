package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPagePO {
	
	WebDriver driver;
	
	public LandingPagePO(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By courses = By.cssSelector("a[href*='https://www.rahulshettyacademy.com/']");
	By title = By.cssSelector(".text-center>h2");
	
	public WebElement getCourses() {
		
		return driver.findElement(courses);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	

}
