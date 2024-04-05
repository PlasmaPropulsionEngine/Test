package extent_reportConfiguration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportConfiguration {


	public static ExtentReports getReportObject()
	{
				String path =System.getProperty("user.dir")+"\\reports\\index.html";
				ExtentSparkReporter reporter =new ExtentSparkReporter(path);
				reporter.config().setReportName("ContactManger Application Test Results");
				reporter.config().setDocumentTitle("Test Results");
				
				ExtentReports extent=new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester","Karan");
		
				return extent;	
		
	}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
