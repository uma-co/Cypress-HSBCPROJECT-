package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport {

	public static ExtentReports reportTestNG() {
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter ep = new ExtentSparkReporter(path);
		ep.config().setDocumentTitle("pizzaReport");
		ep.config().setReportName("PizzaCaseReport");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(ep);
		return extent;
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
}
