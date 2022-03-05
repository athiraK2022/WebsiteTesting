package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursesPO {
	
	WebDriver driver;
	
	public CoursesPO(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	By radiobutton = By.cssSelector("#radio-btn-example > fieldset > label:nth-child(2) > input");
	
	public WebElement getRadiobutton() {
		
		return driver.findElement(radiobutton);
	}

}
