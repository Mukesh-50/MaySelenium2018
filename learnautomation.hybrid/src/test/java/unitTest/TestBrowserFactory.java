package unitTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BrowserFactory;

public class TestBrowserFactory 
{

	@Test
	public void checkBrowserInstance()
	{
		WebDriver driver=BrowserFactory.startApplication("Chrome", "https://www.freecrm.com/index.html");

	    Assert.assertFalse(driver==null);
	    
	    BrowserFactory.closeBrowser(driver);
	}
	
}
