package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Update_ContactPage {
	
	public WebDriver _driver;
	
	public Update_ContactPage(WebDriver _browser)
	{
		_driver = _browser;
		WebDriverWait wait = new WebDriverWait(_driver,5);
		//Waits until the Add a Contact link is displayed on the page
		wait.until((ExpectedConditions.titleContains("View Contact:")));
		wait.until((ExpectedConditions.textToBePresentInElementValue(By.xpath(".//*[@id='main']/form/input[3]"), "Update Contact")));
				
	}

		//Sets the First name of user on the Contact's Update page
		public void setFirstNameOnUpdatePage(String FirstName)
		{
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[2]/input")).clear();
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[2]/input")).sendKeys(FirstName);			
		}
		
		//Sets the Last name of user on the Contact's Update page
		public void setLastNameOnUpdatePage(String LastName)
		{
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[1]/input")).clear();
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[1]/input")).sendKeys(LastName);			
		}
		
		//Sets the Phone Number of user on the Contact's Update page
		public void setPhoneNumberOnUpdatePage(String PhoneNumber)
		{
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[3]/input")).clear();
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[3]/input")).sendKeys(PhoneNumber);			
		}
		
		//Sets the EmailId of user on the Contact's Update page
		public void setEmailIdOnUpdatePage(String EmailId)
		{
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[4]/input")).clear();
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[4]/input")).sendKeys(EmailId);			
		}
		
		//Sets the Street1 details of user on the Contact's Update page
		public void setStreet1OnUpdatePage(String Street1)
		{
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[5]/input")).clear();
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[5]/input")).sendKeys(Street1);			
		}
		
		//Sets the Street2 details of user on the Contact's Update page
		public void setStreet2OnUpdatePage(String Street2)
		{
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[6]/input")).clear();
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[6]/input")).sendKeys(Street2);
		}
		
		//Sets the Region details of user on the Contact's Update page
		public void setRegionOnUpdatePage(String Region)
		{
			WebElement DropdownListBox = _driver.findElement(By.xpath(".//*[@id='Contact_Address_Region']"));
			Select Regioninput = new Select(DropdownListBox);
			Regioninput.selectByVisibleText(Region);
		}
		
		//Sets the City details of user on the Contact's Update page
		public void setCityOnUpdatePage(String City)
		{
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[8]/input")).clear();
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[8]/input")).sendKeys(City);			
		}
		
		//Sets the Zip details of user on the Contact's Update page
		public void setZipOnUpdatePage(String Zip)
		{
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[9]/input")).clear();
			_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[9]/input")).sendKeys(Zip);						
		}
	
		//Clicks Update button on the Update Contact page
		public Home_ContactPage clickUpdateButtonOnUpdatePage()
		{
			_driver.findElement(By.xpath(".//*[@id='main']/form/input[3]")).click();	
			return new Home_ContactPage(_driver);
		}
		
		//Clicks Back to Contacts link on the Update Contact page
		public Home_ContactPage clickBackToContactsLinkOnUpdatePage()
		{
			_driver.findElement(By.linkText("Back to contacts")).click();
			return new Home_ContactPage(_driver);
		}
	
	
}
