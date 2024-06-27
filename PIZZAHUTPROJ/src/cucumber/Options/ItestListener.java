package cucumber.Options;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseTest.btest;
import reports.ExtentReport;

public class ItestListener extends btest implements ITestListener {
	
	protected static ExtentReports extent = ExtentReport.reports();
	private static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();
//	 protected static ExtentTest extentest;
	
	 @Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
		 
	    	extentest = extent.createTest(context.getName());
	    	
		}
	 @Override
	 public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
	
	    	
	    	
		}
	 @Override
	 public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
	
	    	extentest = extent.createTest(result.getMethod().getMethodName());
	    	testThreadLocal.set(extentest);
		}
	 

		@Override
		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			
		extentest.log(Status.PASS , "Test Passed");
		
		}
		

		@Override
		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			extentest.fail(result.getThrowable());
			//testThreadLocal.get().fail(result.getThrowable());
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
			extentest.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
			
		}
		@Override
		public void onTestSkipped(ITestResult result) {
			
			testThreadLocal.get().skip(result.getThrowable());
			
		}
	    
	    
	    }
	    
	    

