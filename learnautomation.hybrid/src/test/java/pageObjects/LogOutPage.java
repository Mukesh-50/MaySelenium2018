package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.Utility;

public class LogOutPage 
{

	WebDriver driver;
	
	 public LogOutPage(WebDriver maindriver) 
	 {
		this.driver=maindriver;
	 }
	
	@FindBy(xpath="//*[contains(text(),'Logout')]") WebElement logoutLink;
	
	public void logOutFromApplication()
	{
		Utility.syncWebElement(driver, logoutLink).click();
	}
	

}
