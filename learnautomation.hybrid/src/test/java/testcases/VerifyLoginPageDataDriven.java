package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import factory.DataProviderFactory;
import pageObjects.BaseClass;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;

public class VerifyLoginPageDataDriven extends BaseClass {

	@Test(dataProvider="CRMLogin1")
	public void validLogin(String uname,String password) 
	{
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		LogOutPage logoutPage = PageFactory.initElements(driver, LogOutPage.class);

		loginPage.loginApplication(uname,password);

		logoutPage.logOutFromApplication();
	}

	@DataProvider(name = "CRMLogin")
	public Object[][] getLoginData() 
	{
		
		Object[][] data = new Object[3][2];
		data[0][0] = "Selenium_50";
		data[0][1] = "Abcd@123456";

		data[1][0] = "Mukesh_50";
		data[1][1] = "Abcd@123456";
		
		data[2][0] = "QTP_50";
		data[2][1] = "Xyz@123456";

		return data;
	}

	@DataProvider(name = "CRMLogin1")
	public Object[][] getLoginData1() 
	{
		Object[][] data = new Object[DataProviderFactory.getExcel().getNumberOfRows("Users")][2];
		
		int row=DataProviderFactory.getExcel().getNumberOfRows("Users");
		
		
		for(int i=0;i<row;i++)
		{
			data[i][0]=DataProviderFactory.getExcel().getStringData("Users", i, 0);
			data[i][1]=DataProviderFactory.getExcel().getStringData("Users", i, 1);
		}
		
		return data;
	}


}
