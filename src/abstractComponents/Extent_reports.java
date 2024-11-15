package abstractComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_reports {

	public static ExtentReports reportTestNG() {
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter ep = new ExtentSparkReporter(path);
		ep.config().setDocumentTitle("PricReport");
		ep.config().setReportName("pricLockedMessagesReport");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(ep);
		return extent;
}}
