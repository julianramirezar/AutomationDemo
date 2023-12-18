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

public class TC2LoginUserCorrect {
	String url = "http://automationexercise.com";
	WebDriver driver;	
	String loginName = "Test User";
	String loginEmail = "testcase2login@example.com";
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
		HomePage home = new HomePage(driver);		
		home.navbarLogin().click();
		LoginPage login = new LoginPage(driver);
		login.setSignUpName(loginName);
		login.setSignUpEmail(loginEmail);			
		login.clickSignUpButton();
		SignupPage signup = new SignupPage(driver);
		signup.createAccount(newAccount);
		AccountCreatedPage accountCreated = new AccountCreatedPage(driver);
		accountCreated.clickContinueButton();
		home.logOut().click();
	}	
	
	@Test 
	public void LoginUserCorrect() {
		// Verify that home page is visible successfully
		HomePage home = new HomePage(driver);
		home.navbarLogin().click();		
		
		// Verify 'Login to your account' is visible
		LoginPage login = new LoginPage(driver);
		Assert.assertTrue(login.loginForm().isDisplayed());		
		Assert.assertTrue(login.loginForm().getText().contains("Login to your account"));
				
		// Verify that 'Logged in as username' is visible
		login.logIn(loginEmail, newAccount[2]);
		Assert.assertTrue(home.loggedInAs().getText().contains("Logged in as " + loginName));
		
		// Verify that 'ACCOUNT DELETED!' is visible
		home.deleteAccount().click();
		AccountDeletedPage accountDeleted = new AccountDeletedPage(driver);
		Assert.assertTrue(accountDeleted.accountDeleted().isDisplayed());		
		Assert.assertTrue(accountDeleted.accountDeleted().getText().contains("ACCOUNT DELETED!"));		
	}	
	
	@AfterSuite
	public void shutDown() {
		driver.close();
	}
}
