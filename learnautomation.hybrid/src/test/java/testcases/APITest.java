package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class APITest 
{

	
	@Test
	public void testResponseCode()
	{
		
		Response res=given().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad");
		
		System.out.println(res.getTime());
		
		System.out.println(res.statusCode());
		
		Assert.assertEquals(res.statusCode(), 200);
		
		System.out.println(res.body().asString());
		
		Assert.assertTrue(res.body().asString().contains("Hyderabad"));
		
	}
	
}
