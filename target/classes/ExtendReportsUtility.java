package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportsUtility {
	
	static ExtentReports ExtentReportsobj;
	
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter ExtentSparkReporterobj = new ExtentSparkReporter(path);
		ExtentSparkReporterobj.config().setReportName("Web Application Automation Result");
		ExtentSparkReporterobj.config().setDocumentTitle("Results");
		
		ExtentReportsobj = new ExtentReports();
		ExtentReportsobj.attachReporter(ExtentSparkReporterobj);
		ExtentReportsobj.setSystemInfo("Tester", "Athira Krishnan");
		return ExtentReportsobj;
		
	}

}
