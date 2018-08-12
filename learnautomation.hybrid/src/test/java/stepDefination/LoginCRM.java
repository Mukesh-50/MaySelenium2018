package stepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;

public class LoginCRM {

	WebDriver driver;
	LoginPage login;
	
	
	@Given("^Open Chrome and start application$")
	public void open_Chrome_and_start_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Chandani_50\\git\\MaySelenium2018_Aug\\learnautomation.hybrid\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.freecrm.com/index.html");
		
	}

	@When("^I enter valid username and valid password$")
	public void i_enter_valid_username_and_valid_password() throws Throwable {
		login=PageFactory.initElements(driver, LoginPage.class);
		login.loginApplication("Selenium_50", "Selenium_50");
	}

	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {
		driver.quit();

	}

}
