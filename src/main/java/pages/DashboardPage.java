package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class DashboardPage {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By menu=By.xpath("//img[@alt='menu']");
	
	By signout=By.xpath("//button[normalize-space()='Sign out']");
	
	By welcomeMsg=By.xpath("//h4");
	
	public String getWelcomeText()
	{
		String msg=Utility.checkElement(driver, welcomeMsg).getText();
		
		return msg;
	}
	
	
	public void logoutFromApplication()
	{
		Utility.clickElement(driver, menu);
		
		Utility.clickElement(driver, signout);
	}
	
	
}
