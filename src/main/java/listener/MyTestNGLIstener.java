package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;

import dataprovider.ConfigUtility;
import factory.BrowserFactory;
import helper.Utility;

public class MyTestNGLIstener implements ITestListener
{
	 public void onTestSuccess(ITestResult result) 
	 {	    
		 
		 ChainTestListener.log("LOG:PASS - Test Passed");
		 
		if(ConfigUtility.readProperty("screenshotOnPassed").equalsIgnoreCase("Yes")
			|| ConfigUtility.readProperty("screenshotOnPassed").equalsIgnoreCase("True"))
		{
			String screenshot=Utility.captureScreenshot(BrowserFactory.getDriver());
			 
			ChainTestListener.embed(screenshot, "image/png");
		}
		 
	 }
	 
	 public void onTestFailure(ITestResult result) 
	 {
		 ChainTestListener.log("LOG:FAIL - Test Failed "+result.getMethod().getMethodName()+" "+result.getThrowable().getMessage());
		 
		 if(ConfigUtility.readProperty("screenshotOnfailure").equalsIgnoreCase("Yes")
				|| ConfigUtility.readProperty("screenshotOnfailure").equalsIgnoreCase("True"))
		 {
			 String screenshot=Utility.captureScreenshot(BrowserFactory.getDriver());
						
			 ChainTestListener.embed(screenshot, "image/png");
		 }
		 
	 }
	 
	 public void onTestSkipped(ITestResult result) 
	 {	
		
		 if(ConfigUtility.readProperty("screenshotOnSkip").equalsIgnoreCase("Yes")
					|| ConfigUtility.readProperty("screenshotOnSkip").equalsIgnoreCase("True"))
			 {
				 String screenshot=Utility.captureScreenshot(BrowserFactory.getDriver());
							
				 ChainTestListener.embed(screenshot, "image/png");
			 }

	 }

}