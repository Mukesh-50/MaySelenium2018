package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import factory.DataProviderFactory;
import pageObjects.BaseClass;
import pageObjects.Contacts;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;

public class CreateContacts2 extends BaseClass {

	LoginPage loginPage;
	LogOutPage logoutPage;
	Contacts contact;

	@Test
	public void validLogin() 
	{
		logger = report.startTest("Login to CRM");

		loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.loginApplication(DataProviderFactory.getExcel().getStringData("Users", 0, 0),
				DataProviderFactory.getExcel().getStringData("Users", 0, 1));

		logger.log(LogStatus.PASS, "User logged in and Validation Pass");
	}

	@Test(dependsOnMethods="validLogin")
	public void createContact() 
	{
		logger = report.startTest("Create Contact in CRM");

		contact = PageFactory.initElements(driver, Contacts.class);

		contact.createContactWithoutDate(DataProviderFactory.getExcel().getStringData("Contacts", 0, 0),
				DataProviderFactory.getExcel().getStringData("Contacts", 0, 1));

		logger.log(LogStatus.PASS, "User Created");
	}

	@Test(dependsOnMethods="createContact",alwaysRun=true)
	public void logOut() 
	{
		logger = report.startTest("Logoff from CRM");

		logoutPage = PageFactory.initElements(driver, LogOutPage.class);

		logoutPage.logOutFromApplication();

		logger.log(LogStatus.INFO, "User logged in and Validation Pass");

	}

}
