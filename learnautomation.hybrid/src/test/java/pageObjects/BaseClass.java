package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.ConfigDataProvider;
import factory.BrowserFactory;
import helper.Utility;

public class BaseClass {
	public WebDriver driver;
	String browser;
	String url;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpReport() {
		report = new ExtentReports("./Reports/CRM_" + Utility.getCurrentDate_Time() + ".html");
	}

	@AfterSuite
	public void tearDownReport() {
		report.flush();
	}

	@AfterMethod
	public void endTest(ITestResult result) 
	{
		String path = Utility.captureScreenshot(driver);
		
		if (result.getStatus() == ITestResult.SUCCESS) 
		{
			logger.log(LogStatus.PASS, logger.addScreenCapture(path));
			
		} else if (result.getStatus() == ITestResult.FAILURE) 
		{
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}

		report.endTest(logger);
	}


	@Parameters("Browser")
	@BeforeClass
	public void setupApplication (String browser){
		ConfigDataProvider config = new ConfigDataProvider();

		//browser = config.getBrowser();

		url = config.getStagingURL();

		driver = BrowserFactory.startApplication(browser, url);
	}

	@AfterClass
	public void tearDownApplication() {
		BrowserFactory.closeBrowser(driver);
	}

}
