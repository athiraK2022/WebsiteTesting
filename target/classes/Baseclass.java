package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Baseclass {
	
	
	
	public WebDriver driver;
	public Properties prop;
	public String url;
	
	
	public static void main(String a[]) {
		 DOMConfigurator.configure("log4j.xml"); 
		
	}
	
	public WebDriver initializeDriver() throws IOException {
		
		
		

		prop= new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\91860\\eclipse-workspace\\WebsiteTesting\\src\\test\\java\\utilities\\browsername.properties");
		prop.load(fis);
		
		String browsername = prop.getProperty("browser");
		url = prop.getProperty("url");
		
		
		
		
		if(browsername.equals("chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\91860\\eclipse-workspace\\WebsiteTesting\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
			
			
		}
		
		
		
		return driver;
		
	
	}
	
	
	
	
public String getScreenshotpath(String Testcasename, WebDriver driver) throws IOException {
	//Log.info("getscreenshot mthod working");
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destfile = System.getProperty("user.dir")+"\\reports\\"+Testcasename+".png";
	FileUtils.copyFile(source,new File(destfile));
	return destfile;

}
}
