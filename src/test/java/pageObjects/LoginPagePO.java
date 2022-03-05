package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePO {

	public WebDriver driver;
	
	public LoginPagePO(WebDriver driver) {
	
		this.driver = driver;
	}
	
	By loginbutton = By.cssSelector("a[href='https://rahulshettyacademy.com/sign_in/']");
	By emailID = By.cssSelector("input[id='user_email']");
	By passwordfield = By.cssSelector("input[id='user_password']");
	By submit = By.cssSelector("input[value='Log In']");
	By wrongid = By.cssSelector("#hero > div > div");
	
	public WebElement getloginbutton() {
		
		return driver.findElement(loginbutton);
	}
	public WebElement getemailID() {
		
		return driver.findElement(emailID);
	}
	
	public WebElement getPasswordfield() {
		
		return driver.findElement(passwordfield);
	}
	
	public WebElement getsumit() {
		
		return driver.findElement(submit);
	}
	
	public WebElement getWrongid() {
		
		return driver.findElement(wrongid);
	}
	
	
	
	
	
	
	
}
