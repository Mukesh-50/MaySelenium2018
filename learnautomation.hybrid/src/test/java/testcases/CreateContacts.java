package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import factory.DataProviderFactory;
import pageObjects.BaseClass;
import pageObjects.Contacts;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;

public class CreateContacts extends BaseClass {

	@Test
	public void validLogin() 
	{
		logger=report.startTest("Create Contact in CRM");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		LogOutPage logoutPage = PageFactory.initElements(driver, LogOutPage.class);

		Contacts contact = PageFactory.initElements(driver, Contacts.class);

		loginPage.loginApplication(DataProviderFactory.getExcel().getStringData("Users", 0, 0),
				DataProviderFactory.getExcel().getStringData("Users", 0, 1));

		logger.log(LogStatus.PASS, "User logged in and Validation Pass");
		
		contact.createContactWithoutDate(DataProviderFactory.getExcel().getStringData("Contacts", 0, 0),
				DataProviderFactory.getExcel().getStringData("Contacts", 0,1));

		logger.log(LogStatus.PASS, "User Created");
		
		logoutPage.logOutFromApplication();
		
		logger.log(LogStatus.INFO, "User logged in and Validation Pass");
		
		report.endTest(logger);
	}

}
