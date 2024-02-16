package AutomationDemo;

import java.lang.invoke.MethodHandles;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.AccountCreatedPage;
import Pages.AccountDeletedPage;
//import Pages.AccountDeletedPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignupPage;
import Utils.User;

public class TC1RegisterUser {
	String url = "http://automationexercise.com";
	String testCaseName = MethodHandles.lookup().lookupClass().getSimpleName();
	WebDriver driver;
	User newUser = new User();

	@BeforeMethod
	public void setUp() {
		// Set Chrome options for running in headless mode
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless"); // Run Chrome in headless mode
		chromeOptions.addArguments("--disable-gpu"); // Disable GPU acceleration
		chromeOptions.addArguments("--remote-allow-origins=*");

		// Path to your Chrome WebDriver executable
		// System.setProperty("webdriver.chrome.driver", "C:\\chrome-win64");

		driver = new ChromeDriver(chromeOptions);
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

		login.signUp(newUser.getUsername(), newUser.getEmail());

		// Verify that 'ENTER ACCOUNT INFORMATION' is visible
		SignupPage signup = new SignupPage(driver);
		Assert.assertTrue(signup.loginForm().isDisplayed());
		Assert.assertTrue(signup.loginForm().getText().contains("ENTER ACCOUNT INFORMATION"));
		signup.createAccount(newUser);

		// Verify that 'ACCOUNT CREATED!' is visible
		AccountCreatedPage accountCreated = new AccountCreatedPage(driver);
		Assert.assertTrue(accountCreated.accountCreated().isDisplayed());
		Assert.assertTrue(accountCreated.accountCreated().getText().contains("ACCOUNT CREATED!"));
		driver.navigate().refresh();
		accountCreated.clickContinueButton();

		// Verify that 'Logged in as username' is visible

		Assert.assertTrue(home.loggedInAs().getText().contains("Logged in as " + newUser.getUsername()));
		home.deleteAccount().click();

		// Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
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
