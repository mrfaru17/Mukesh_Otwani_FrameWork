package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.chaintest.plugins.ChainTestListener;
import base.BaseClass;
import dataprovider.DataProviders;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginApplicationTest extends BaseClass
{
	LoginPage login;
	
	DashboardPage dashboard;
	
	@Test(priority = 1,enabled = true,dataProvider = "logincredentials",dataProviderClass = DataProviders.class)
	public void loginWithValidCredentials(String user,String pass)
	{
		login=new LoginPage(driver);
		
		dashboard=login.loginToApplication(user,pass);
		
		ChainTestListener.log("LOG:INFO - User is able to login");
	
		Assert.assertTrue(dashboard.getWelcomeText().contains("Welcome"),"Login Failed");
		
		ChainTestListener.log("LOG:PASS - User is able to welcome msg");
		
	
	}
	
	@Test(dependsOnMethods = "loginWithValidCredentials",priority = 2,enabled = true)
	public void logoutFromApplication()
	{
		dashboard.logoutFromApplication();
		
		ChainTestListener.log("LOG:INFO - User is able to logout");
		
		Assert.assertTrue(login.isSignUpPresent(),"Logout Failed");

	}
	
	@Test(priority = 3)
	public void verifyFooterLinks()
	{
		int count=login.countFooterLinks();
		
		Assert.assertEquals(count, 4 ,"footer links mismatched");

		ChainTestListener.log("LOG:PASS - Footer links verified");
		
	}
	
	@Test(priority = 4)
	public void verifyNewUserLinks()
	{
		boolean status=login.isSignUpLinkPresent();
		
		Assert.assertTrue(status);
		
		ChainTestListener.log("LOG:PASS - Signup Link is present");
		

		
	}
	
	
	

}
