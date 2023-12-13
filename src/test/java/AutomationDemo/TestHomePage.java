package AutomationDemo;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Pages.HomePage;

public class TestHomePage {
	String url = "http://www.automationpractice.pl/index.php";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();		
	}
	
	@Test 
	public void OpenMainSite() {
		HomePage home = new HomePage(driver);
		//home.clickSubmitSearch();
		String pageTitle = driver.getTitle();
		Assert.assertEquals("My Shop", pageTitle);		
	}
	
	@AfterSuite
	public void shutDown() {
		driver.close();
	}
}
