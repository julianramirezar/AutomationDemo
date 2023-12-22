package AutomationDemo;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Pages.AccountCreatedPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignupPage;

public class TC5RegisterExistingEmail {
	String url = "http://automationexercise.com";
	WebDriver driver;	
	String loginName = "Test User";
	String loginEmail = "testcase5existing@example.com";
	String loginPassword = "password123";
	
	String[] newAccount = {"M", "Test User", loginPassword, "23", "June", "1989",
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
		HomePage home = new HomePage(driver);		
		home.navbarLogin().click();
		LoginPage login = new LoginPage(driver);
		login.signUp(loginName, loginEmail);
		SignupPage signup = new SignupPage(driver);
		signup.createAccount(newAccount);
		AccountCreatedPage accountCreated = new AccountCreatedPage(driver);
		accountCreated.clickContinueButton();
		home.logOut().click();
	}	
	
	@Test 
	public void RegisterExistingEmail() {
		// Verify that home page is visible successfully
		HomePage home = new HomePage(driver);
		home.navbarLogin().click();		
		
		// Verify 'New User Signup!' is visible
		LoginPage login = new LoginPage(driver);
		Assert.assertTrue(login.signupForm().isDisplayed());		
		Assert.assertTrue(login.signupForm().getText().contains("New User Signup!"));		
				
		// Verify error 'Email Address already exist!' is visible
		login.signUp(loginName, loginEmail);
		Assert.assertTrue(login.signupForm().getText().contains("Email Address already exist!"));
	}	
	
	@AfterSuite
	public void shutDown() {		
		LoginPage login = new LoginPage(driver);
		login.logIn(loginEmail, loginPassword);
		HomePage home = new HomePage(driver);
		home.deleteAccount().click();
		driver.close();
	}
}