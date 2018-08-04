package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import helper.Utility;

public class Contacts {

	WebDriver driver;

	public Contacts(WebDriver driver) {
		this.driver = driver;
	}

	By contacts = By.xpath("//a[text()='Contacts']");

	@FindBy(xpath = "//a[text()='New Contact']")
	WebElement newContact;

	@FindBy(how = How.XPATH, using ="//*[text()='First Name']//following::input[1]")
	WebElement firstName;

	@FindBy(how = How.ID, using = "surname")
	WebElement lastName;

	@FindBy(how = How.XPATH, using = "//img[@title='Date selector']")
	WebElement clickOnCale;

	@FindBy(how = How.XPATH, using = "(//div[@class='calendar'])[2]//tbody//tr[@class='daysrow']//td")
	List<WebElement> allDates;

	@FindBy(how = How.XPATH, using = "//td[@class='title']//..//..//..//tbody//td[text()='3']")
	WebElement specificDate;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='calendar'])[2]//tbody//tr[@class='daysrow']//td[text()='3']")
	WebElement specificDateNew;

	@FindBy(how = How.XPATH, using = "//input[@value='Load From Company']//following::input[1]")
	WebElement saveButton;

	public void createContactWithDate(String fName, String lName, String date) {

	}

	public void createContactWithoutDate(String fName, String lName) {

		Utility.switchToFrameUsingIdAndName(driver, "mainpanel");
		
		Actions act = new Actions(driver);

		act.moveToElement(driver.findElement(contacts)).pause(1000).moveToElement(newContact).click().build().perform();

/*		Utility.waitForWebElement(driver, firstName).sendKeys(fName);
		
		Utility.waitForWebElement(driver, lastName).sendKeys(lName);
		
		Utility.waitForWebElement(driver, clickOnCale).click();
		
		Utility.waitForWebElement(driver, specificDate).click();
		
		Utility.waitForWebElement(driver, saveButton).click();*/
		

		Utility.syncWebElement(driver, firstName).sendKeys(fName);
		
		Utility.syncWebElement(driver, lastName).sendKeys(lName);
		
		Utility.syncWebElement(driver, clickOnCale).click();
		
		Utility.syncWebElement(driver, specificDate).click();
		
		Utility.syncWebElement(driver, saveButton).click();
		
		

	}

}
