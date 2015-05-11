import static org.junit.Assert.*;

import java.net.URL;
import java.util.Random;

import org.junit.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Add_ContactPage;
import pageObjects.Home_ContactPage;
import pageObjects.View_ContactPage;
 
public class ContactManager {
	
	//public WebDriver _browser;
	public RemoteWebDriver _browser;
	public static WebDriverWait wait;
	
  @Before
	public void _Setup() throws Exception	{
	      ///Uncomment the below three rows when tests are run using Selenium Grid or local WebDriver
		  //System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
		  //System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		 // System.setProperty("webdriver.ie.driver", "lib\\IEDriverServer.exe"); 
	     URL sauceLabsURL = new URL("http://ondemand.saucelabs.com/wd/hub");	
	   ///Uncomment the below row when tests are run using Selenium Grid
	     //URL seleniumGridURL = new URL("http://localhost:4444/wd/hub");  
		  
		  DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		//(Comment out the below two lines (Sauce labs username and account key) when Selenium Grid is being used)
          caps.setCapability("username", "mohanthalla"); // supply sauce labs username
          caps.setCapability("accessKey", "941b320d-a07a-463c-8fc3-f8083e453e91");  // supply sauce labs account key 
          caps.setCapability("platform", "Windows 7");
          caps.setCapability("version", "11.0");	
		  
		  //Currently running tests on "SauceLabs", replace the "sauceLabsURL" 
          //with "seleniumGridURL" if tests need to be run on Selenium Grid
		  _browser = new RemoteWebDriver(sauceLabsURL, caps);
		  //_browser = new InternetExplorerDriver();
		  //_browser = new FirefoxDriver();
		  //_browser = new ChromeDriver();
		  _browser.navigate().to("http://devcontactmanager.devlab.qualit.co.nz/");
		  _browser.manage().window().maximize();
		 		
	}	
	
 @Test
 //Test is used to create a contact and then view the created contact details and verify the details entered are correct
 public void AddViewTest() throws Exception { 
 
  Home_ContactPage objHome = new Home_ContactPage(_browser);
  
  Random rand = new Random();
  int randomnumber = rand.nextInt(20000);
  
  String FirstName = "TestFirstName"+randomnumber+"";
  String LastName = "TestLastName"+randomnumber+"";
  String Phone = "041234567";
  String EmailId = "TestEmail"+randomnumber+"";
  String Street1 = "TestStreet1"+randomnumber+"";
  String Street2 = "TestStreet2"+randomnumber+"";
  String State = "CA";
  String City = "Los Angeles";
  String Zip = "23145";
  
  Add_ContactPage objAdd =  objHome.ClickAddaContactLinkOnHomePage();
 objAdd.EnterFormDetails(FirstName, LastName, Phone, EmailId, Street1, Street2, State, City, Zip);
 objAdd.ClickAddContactButtonOnAddContactPage();
  
 //Clicks the View link of the last contact in the table
  View_ContactPage objView = objHome.ClickViewLinkOnHomePage();
  
  //Get values from the View page of a Contact 
  String FirstNameOnViewPage = objView.getFirstName();
  String LastNameOnViewPage = objView.getLastName();
  String PhoneOnViewPage = objView.getPhoneNumber();
  String EmailIdOnViewPage = objView.getEmailId();
  String Street1OnViewPage = objView.getStreet1();
  String Street2OnViewPage = objView.getStreet2();
  String StateOnViewPage = objView.getState();
  String CityOnViewPage = objView.getCity();
  String ZipOnViewPage = objView.getZip();
  
  //Asserting the details on the View page match the details used during Contact addition
  assertEquals("FirstName is correct", FirstName, FirstNameOnViewPage);
  assertEquals("LastName is correct", LastName, LastNameOnViewPage);
  assertEquals("Phonenumber is correct", Phone, PhoneOnViewPage);
  assertEquals("EmailId is correct", EmailId, EmailIdOnViewPage);
  assertEquals("Street1 is correct", Street1, Street1OnViewPage);
  assertEquals("Street2 is correct", Street2, Street2OnViewPage);  
  assertEquals("State is correct", State, StateOnViewPage);
  assertEquals("City is correct", City, CityOnViewPage);
  assertEquals("Zip is correct", Zip, ZipOnViewPage);
  
  objView.clickBackToContactLinkOnViewPage(); 
 }
 
  @Test
//Deletes the last contact of the table
 public void DeleteTest() throws Exception { 
	 
	  Home_ContactPage objHome = new Home_ContactPage(_browser);
	  //Clicks the Delete link of the last contact in the table and returns a boolean value for the status of the Contact deletion
	  boolean ContactDeletionStatus = objHome.ClickDeleteLinkOnHomePage();
	  Assert.assertTrue("Contact Deletion is successful" , ContactDeletionStatus);	   	      
	 }
 
 @After
public void Teardown() {
	 _browser.quit();	
}
}