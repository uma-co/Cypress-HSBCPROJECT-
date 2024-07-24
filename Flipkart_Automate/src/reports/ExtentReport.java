package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport  {
	private static ExtentReports extent;
	public synchronized static ExtentReports reports() {
		
		if(extent == null) {
			String path = System.getProperty("user.dir")+"//reports//index.html";
			ExtentSparkReporter ep = new ExtentSparkReporter(path);
			ep.config().setDocumentTitle("pizzaReport");
			ep.config().setReportName("PizzaCaseReport");
		extent = new ExtentReports();
			
			extent.attachReporter(ep);
		}
		
		//String path = System.getProperty("user.dir")+"//reports//index.html";
//		ExtentSparkReporter ep = new ExtentSparkReporter(path);
//		ep.config().setDocumentTitle("pizzaReport");
//		ep.config().setReportName("PizzaCaseReport");
//		ExtentReports extent = new ExtentReports();
//		
//		extent.attachReporter(ep);
		return extent;
		
		
	}

}
