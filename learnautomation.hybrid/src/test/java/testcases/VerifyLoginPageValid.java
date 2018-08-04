package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import factory.DataProviderFactory;
import helper.Utility;
import pageObjects.BaseClass;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;

public class VerifyLoginPageValid extends BaseClass {

	@Test
	public void validLogin() 
	{
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		LogOutPage logoutPage = PageFactory.initElements(driver, LogOutPage.class);

		loginPage.loginApplication(DataProviderFactory.getExcel().getStringData("Users", 0, 0),
				DataProviderFactory.getExcel().getStringData("Users", 0, 1));

		Utility.captureScreenshot(driver);
		
		logoutPage.logOutFromApplication();
	}

}
