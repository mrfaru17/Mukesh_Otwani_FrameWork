package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class LoginPage 
{

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username=By.xpath("//input[@id='email1']");
	
	By password=By.xpath("//input[@id='password1']");
	
	By loginButton=By.xpath("//button[normalize-space()='Sign in']");
	
	By signIn=By.xpath("//h2[normalize-space()='Sign In']");
	
	By footerIcon=By.xpath("//div[contains(@class,'footer')]//a");
	
	By signUpLink=By.xpath("//a[normalize-space()='New user? Signup']");
	
	
	public boolean isSignUpLinkPresent()
	{
		
		boolean status=Utility.checkElement(driver, signUpLink).isDisplayed();
		
		return status;
		
	}
	
	public int countFooterLinks()
	{
		int count=driver.findElements(footerIcon).size();
		
		return count;
		
	}
		
	public boolean isSignUpPresent()
	{
		boolean status=Utility.checkElement(driver, signIn).isDisplayed();
		
		return status;
	}

	public DashboardPage loginToApplication(String user,String pass)
	{
		Utility.typeOnElement(driver, username, user);
		
		Utility.typeOnElement(driver, password, pass);
		
		Utility.clickElement(driver, loginButton);
		
		
		DashboardPage dashboard=new DashboardPage(driver);
		
		return dashboard;
	}
	
/*
	public void loginToApplication_2(String user,String pass)
	{
		driver.findElement(username).sendKeys(user);
		
		driver.findElement(password).sendKeys(pass);
		
		driver.findElement(loginButton).click();

	}
	
*/	
	
	
}
