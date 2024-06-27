package Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Writable;

import reports.Extentreport;

public class listener  extends BaseTest implements ITestListener{
ExtentTest extent;
ExtentReports test = Extentreport.reportTestNG();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extent = test.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extent.log(Status.PASS , "Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extent.fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		String path = null;
		try {
			path =getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	

	
	public void onFinish(ITestResult result) {
		// TODO Auto-generated method stub
		((Writable) extent).flush();
	}

	
	
}
