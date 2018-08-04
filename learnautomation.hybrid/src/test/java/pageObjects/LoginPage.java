package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.Utility;

public class LoginPage 
{
	WebDriver driver;

	public LoginPage(WebDriver mainDriver)
	{
		this.driver=mainDriver;
	}
	
	@FindBy(name="username") WebElement username;
	
	@FindBy(xpath="//input[@name='password']") WebElement password;
	
	@FindBy(xpath="//input[@value='Login']") WebElement loginButton;

	
	public void typeUserName()
	{
		username.sendKeys("Selenium_50");
	}
	
	public void typePassword()
	{
		password.sendKeys("Abcd@123456");
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	public void loginApplication(String uname,String pass)
	{
		
		Utility.syncWebElement(driver,username).sendKeys(uname);
		Utility.syncWebElement(driver,password).sendKeys(pass);
		Utility.syncWebElement(driver,loginButton).click();

	}
	
	
}
