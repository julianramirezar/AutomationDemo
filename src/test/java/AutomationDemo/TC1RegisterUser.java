package AutomationDemo;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Pages.HomePage;
import Pages.LoginPage;

public class TC1RegisterUser {
	String url = "http://automationexercise.com";
	WebDriver driver;
	String loginName = "Test User";
	String loginEmail = "testrandom141223@example.com";
	
	@BeforeSuite
	public void setUp() {		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();		
	}
	
	
	
	@Test 
	public void VerifyHomePage() {
		HomePage home = new HomePage(driver);
		
		// Verify that home page is visible successfully
		Assert.assertTrue(driver.findElement(By.id("slider-carousel")).isDisplayed());
		home.clickLogin();
		
		// Verify 'New User Signup!' is visible
		Assert.assertTrue(driver.findElement(By.className("signup-form")).isDisplayed());		
		Assert.assertEquals("New User Signup!",driver.findElement(By.xpath("//div[@class='signup-form']/h2")).getText());
	
		LoginPage login = new LoginPage(driver);

		login.setSignUpName(loginName);
		login.setSignUpEmail(loginEmail);			
		login.clickSignUpButton();
		
		// Verify that 'ENTER ACCOUNT INFORMATION' is visible
		Assert.assertTrue(driver.findElement(By.className("login-form")).isDisplayed());		
		Assert.assertEquals("ENTER ACCOUNT INFORMATION",driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText());
		
	}
	
	
	@AfterSuite
	public void shutDown() {
		driver.close();
	}
}
