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
import Pages.SignupPage;

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
		Assert.assertTrue(home.sliderCarousel().isDisplayed());
		home.clickLogin();		
		
		// Verify 'New User Signup!' is visible
		LoginPage login = new LoginPage(driver);
		Assert.assertTrue(login.signupForm().isDisplayed());		
		Assert.assertTrue(login.signupForm().getText().contains("New User Signup!"));		

		login.setSignUpName(loginName);
		login.setSignUpEmail(loginEmail);			
		login.clickSignUpButton();
		
		// Verify that 'ENTER ACCOUNT INFORMATION' is visible
		SignupPage signup = new SignupPage(driver);
		Assert.assertTrue(signup.loginForm().isDisplayed());		
		Assert.assertTrue(signup.loginForm().getText().contains("ENTER ACCOUNT INFORMATION"));
		
	}	
	
	@AfterSuite
	public void shutDown() {
		driver.close();
	}
}
