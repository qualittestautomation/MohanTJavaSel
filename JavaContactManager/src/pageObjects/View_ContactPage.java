package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class View_ContactPage {
	
	public WebDriver _driver;
	
	public View_ContactPage(WebDriver _browser)
	{
		_driver = _browser;
		WebDriverWait wait = new WebDriverWait(_driver,5);
		//Waits until the Add a Contact link is displayed on the page
		wait.until((ExpectedConditions.titleContains("View Contact:")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='addContactLink']")));				
	}
	
	public String getFirstName()
	{
		String FirstName = _driver.findElement(By.xpath(".//*[@id='main']/ul/li[1]/label[2]")).getText();
		return FirstName;
	}
	
	public String getLastName()
	{
		String LastName = _driver.findElement(By.xpath(".//*[@id='main']/ul/li[2]/label[2]")).getText();
		return LastName;
	}
	
	public String getPhoneNumber()
	{
		String PhoneNumber = _driver.findElement(By.xpath(".//*[@id='main']/ul/li[3]/label[2]")).getText();
		return PhoneNumber;
	}
	
	public String getEmailId()
	{
		String EmailId = _driver.findElement(By.xpath(".//*[@id='main']/ul/li[4]/label[2]")).getText();
		return EmailId;		
	}
	
	public String getStreet1()
	{
		String Street1 = _driver.findElement(By.xpath(".//*[@id='main']/ul/li[5]/label[2]")).getText();
		return Street1;	
	}
	
	public String getStreet2()
	{
		String Street2 = _driver.findElement(By.xpath(".//*[@id='main']/ul/li[6]/label[2]")).getText();
		return Street2;	
	}
	
	public String getState()
	{
		String State = _driver.findElement(By.xpath(".//*[@id='main']/ul/li[7]/label[2]")).getText();
		return State;	
	}
	
	public String getCity()
	{
		String City = _driver.findElement(By.xpath(".//*[@id='main']/ul/li[8]/label[2]")).getText();
		return City;	
	}
	
	public String getZip()
	{
		String Zip = _driver.findElement(By.xpath(".//*[@id='main']/ul/li[9]/label[2]")).getText();
		return Zip;	
	}
	
	public void clickBackToContactLinkOnViewPage()
	{
		_driver.findElement(By.xpath(".//*[@id='main']/a")).click();
	}	
}