package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listners extends Baseclass implements ITestListener {
	ExtentReports ExtentReportsobj = ExtendReportsUtility.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> test_thread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		String testmethodname = result.getMethod().getMethodName();
		test=ExtentReportsobj.createTest(testmethodname);
		test_thread.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testmethodname = result.getMethod().getMethodName();
		test_thread.get().log(Status.PASS,testmethodname+" Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testmethodname = result.getMethod().getMethodName();
		test_thread.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		//String testmethodname = result.getMethod().getMethodName();
		
			try {
				driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				
			} catch (Exception e) 
			{
				System.out.println("catched at first try block");
			}
			try {
				String dest_file = getScreenshotpath(testmethodname,driver);
				test_thread.get().addScreenCaptureFromPath(testmethodname,dest_file);
				
				
			}catch(Exception e)
			{
				
				System.out.println("catched at second try block");
			}
		
		}
		
	
		
	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		ExtentReportsobj.flush();
		
	}
	

}
