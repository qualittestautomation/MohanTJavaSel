package pageObjects;



import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Add_ContactPage {
	
	
    public WebDriver _driver;
	
	public Add_ContactPage(WebDriver _browser)
	{
		_driver = _browser;
		WebDriverWait wait = new WebDriverWait(_driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='main']/a")));
				
	}
	
	public void EnterFormDetails(String FirstName, String LastName, String Phone, String EmailId, String Street1, String Street2, String State, String City, String Zip)
	{
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[1]/input")).clear();
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[1]/input")).sendKeys(FirstName);
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[2]/input")).clear();
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[2]/input")).sendKeys(LastName);
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[3]/input")).clear();
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[3]/input")).sendKeys(Phone);
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[4]/input")).clear();
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[4]/input")).sendKeys(EmailId);
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[5]/input")).clear();
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[5]/input")).sendKeys(Street1);
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[6]/input")).clear();
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[6]/input")).sendKeys(Street2);		
		WebElement DropdownListBox = _driver.findElement(By.xpath(".//*[@id='Contact_Address_State']"));
		Select Stateinput = new Select(DropdownListBox);
		Stateinput.selectByValue(State);		
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[8]/input")).clear();
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[8]/input")).sendKeys(City);
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[9]/input")).clear();
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/li[9]/input")).sendKeys(Zip);				
	}
	
	public Home_ContactPage ClickAddContactButtonOnAddContactPage()
	{
		_driver.findElement(By.xpath(".//*[@id='main']/form/ul/input")).click();
		return new Home_ContactPage(_driver);
	}
	
	public Home_ContactPage ClickBackToContactsLinkOnAddContactPage()
	{
		_driver.findElement(By.xpath(".//*[@id='main']/a")).click();
		return new Home_ContactPage(_driver);
	}
	
		

}
