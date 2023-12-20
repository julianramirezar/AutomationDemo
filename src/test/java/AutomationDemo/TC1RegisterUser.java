package AutomationDemo;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Pages.AccountCreatedPage;
import Pages.AccountDeletedPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignupPage;

public class TC1RegisterUser {
	String url = "http://automationexercise.com";
	WebDriver driver;
	int randomNumber = (int)(Math.random()*10000);
	String loginName = "Test User";
	String loginEmail = "testrandom" + randomNumber + "@example.com";
	String[] newAccount = {"M", "Test User", "password123", "23", "June", "1989",
			"Test", "User", "TestCompany", "Evergreen St. 123", "5th floor","United States",
			"California", "Los Angeles", "90210", "011899621"};
	/*
	String gender, String username, String password, String day,
	String month, String year, String firstName, String lastName,
	String company, String address1, String address2, String country, 
	String state, String City, String zipCode, String mobile
	*/
			
	@BeforeSuite
	public void setUp() {		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();		
	}	
	
	@Test 
	public void RegisterUser() {
		HomePage home = new HomePage(driver);
		
		// Verify that home page is visible successfully
		Assert.assertTrue(home.sliderCarousel().isDisplayed());
		home.navbarLogin().click();		
		
		// Verify 'New User Signup!' is visible
		LoginPage login = new LoginPage(driver);
		Assert.assertTrue(login.signupForm().isDisplayed());		
		Assert.assertTrue(login.signupForm().getText().contains("New User Signup!"));		

		login.signUp(loginName, loginEmail);
		
		// Verify that 'ENTER ACCOUNT INFORMATION' is visible
		SignupPage signup = new SignupPage(driver);
		Assert.assertTrue(signup.loginForm().isDisplayed());		
		Assert.assertTrue(signup.loginForm().getText().contains("ENTER ACCOUNT INFORMATION"));
		signup.createAccount(newAccount);
		
		// Verify that 'ACCOUNT CREATED!' is visible
		AccountCreatedPage accountCreated = new AccountCreatedPage(driver);
		Assert.assertTrue(accountCreated.accountCreated().isDisplayed());		
		Assert.assertTrue(accountCreated.accountCreated().getText().contains("ACCOUNT CREATED!"));
		accountCreated.clickContinueButton();
		
		// Verify that 'Logged in as username' is visible		
		Assert.assertTrue(home.loggedInAs().getText().contains("Logged in as " + loginName));
		home.deleteAccount().click();
		
		// Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
		AccountDeletedPage accountDeleted = new AccountDeletedPage(driver);
		Assert.assertTrue(accountDeleted.accountDeleted().isDisplayed());		
		Assert.assertTrue(accountDeleted.accountDeleted().getText().contains("ACCOUNT DELETED!"));			
	}	
	
	@AfterSuite
	public void shutDown() {
		driver.close();
	}
}
