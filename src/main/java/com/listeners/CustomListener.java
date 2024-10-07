package com.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.UtilityTest;



public class CustomListener extends TestBase  implements ITestListener{
  
	

	static Logger logger = Logger.getLogger(CustomListener.class);
	UtilityTest utility;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test case started: " + result.getName());
		test=report.createTest(result.getName());
		test.log(Status.INFO,"The test case is started :"+result.getName());
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test case passed: " + result.getName());	
		test=report.createTest(result.getName());
		test=test.log(Status.PASS,"The test case is Passed :"+result.getName());
		}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.error("Test case failed: " + result.getName());	
		utility=new UtilityTest();
		byte[] screenshotBytes = utility.takeScreenShotFailure(driver);
        if (screenshotBytes != null) {
            test.log(Status.FAIL, "Screenshot captured for failed test case: " + result.getName());
        }
		test=report.createTest(result.getName());
		test=test.log(Status.FAIL,"The test case is Failure :"+result.getName());
		test=test.log(Status.FAIL,"The test case is Failure :"+result.getThrowable());
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn("Test case skipped: " + result.getName());	
		test=report.createTest(result.getName());
		test=test.log(Status.SKIP,"The test case is Skipped :"+result.getName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
	    report.flush();
	    logger.info("Flushed the Extent report.");
	}
	


}
