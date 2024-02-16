package AutomationDemo;

import java.lang.invoke.MethodHandles;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.AccountCreatedPage;
import Pages.AccountDeletedPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignupPage;
import Utils.User;

public class TC2LoginUserCorrect {
	String url = "http://automationexercise.com";
	String testCaseName = MethodHandles.lookup().lookupClass().getSimpleName();
	WebDriver driver;
	User newUser = new User();	

	@BeforeMethod
	public void setUp() {		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		HomePage home = new HomePage(driver);		
		home.navbarLogin().click();
		LoginPage login = new LoginPage(driver);
		login.signUp(newUser.getUsername(), newUser.getEmail());
		SignupPage signup = new SignupPage(driver);
		signup.createAccount(newUser);
		driver.navigate().refresh();
		AccountCreatedPage accountCreated = new AccountCreatedPage(driver);
		accountCreated.clickContinueButton();
		driver.navigate().refresh();
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
		login.logIn(newUser.getEmail(), newUser.getPassword());
		Assert.assertTrue(home.loggedInAs().getText().contains("Logged in as " + newUser.getUsername()));
		
		// Verify that 'ACCOUNT DELETED!' is visible
		home.deleteAccount().click();
		AccountDeletedPage accountDeleted = new AccountDeletedPage(driver);
		Assert.assertTrue(accountDeleted.accountDeleted().isDisplayed());		
		Assert.assertTrue(accountDeleted.accountDeleted().getText().contains("ACCOUNT DELETED!"));		
	}
	
	@AfterMethod
	public void onFailure(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utils.TakeScreenshot.saveScreen(driver, testCaseName);
		}
	}
	
	@AfterClass
	public void shutDown() {
		driver.close();
	}
}
