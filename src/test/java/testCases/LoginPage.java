package testCases;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.LoginPagePO;
import utilities.Baseclass;

public class LoginPage extends Baseclass{
	
	WebDriver driver;
	static Logger log = LogManager.getLogger(LoginPage.class.getName());
	
	@BeforeMethod
	
	public void driverInitialize() throws IOException {
		
		driver = initializeDriver();
		log.info("driver initialized");
		driver.get(url);
		log.info("URL loaded");
	}
	
	@Test(dataProvider="getData")
	
	public void checklogin(String name, String id) throws IOException, InterruptedException {
		
		
		 
		
		LoginPagePO lp  = new LoginPagePO(driver);
		lp.getloginbutton().click();
		lp.getemailID().sendKeys(name);
		lp.getPasswordfield().sendKeys(id);
		lp.getsumit().click();
		String msg = lp.getWrongid().getText();
		Assert.assertEquals("Invalid email or password.", msg);
		log.info("checklogin is passed");
		
		
		
		
		
	}
	
	@AfterMethod
	
	public void tearDown() {
		
		driver.close();
		log.info("driver closed");
	}
	
	@DataProvider
	
	public Object[][] getData() {
		
		Object[][] obj = new Object[2][2];
		obj[0][0]= "athira";
		obj[0][1]="athira364@gmail.com";
		obj[1][0]="anju";
		obj[1][1]="anjana@gmail.com";
		
		return obj;
	}
	
	
	

}
