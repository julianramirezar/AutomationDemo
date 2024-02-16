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
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignupPage;
import Utils.User;

public class TC5RegisterExistingEmail {
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
		home.Home().click();
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
		login.signUp(newUser.getUsername(), newUser.getEmail());
		Assert.assertTrue(login.signupForm().getText().contains("Email Address already exist!"));
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