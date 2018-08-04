package unitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class VerifyDataProvider 
{

	@Test
	public void testExcel()
	{
		ExcelDataProvider excel=new ExcelDataProvider();
		
		Assert.assertEquals(excel.getStringData("Users", 0, 0), "Selenium_50");
	}
	
	@Test
	public void testConfig()
	{
		ConfigDataProvider excel=new ConfigDataProvider();
		
		Assert.assertEquals(excel.getBrowser(),"Chrome");
		
		Assert.assertEquals(excel.getValueFromConfig("name"),"MukeshOtwani");
	}
	
	
}
