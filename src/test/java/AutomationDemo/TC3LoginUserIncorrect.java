package AutomationDemo;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Pages.HomePage;
import Pages.LoginPage;

public class TC3LoginUserIncorrect {
	String url = "http://automationexercise.com";
	String testCaseName = MethodHandles.lookup().lookupClass().getSimpleName();
	Faker faker = new Faker();
	String incorrectEmail = faker.internet().emailAddress();
	String incorrectPassword = faker.internet().password();
	WebDriver driver;
			
	@BeforeMethod
	public void setUp() {		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();		
	}	
	
	@Test 
	public void LoginUserIncorrect() throws IOException {
		HomePage home = new HomePage(driver);
		
		// Verify that home page is visible successfully
		Assert.assertTrue(home.sliderCarousel().isDisplayed());
		home.navbarLogin().click();		
			
		// Verify 'Login to your account' is visible
		LoginPage login = new LoginPage(driver);
		Assert.assertTrue(login.loginForm().isDisplayed());		
		Assert.assertTrue(login.loginForm().getText().contains("Login to your account"));
		
		// Verify error 'Your email or password is incorrect!' is visible
		login.logIn(incorrectEmail, incorrectPassword);
		Assert.assertTrue(login.loginForm().getText().contains("Your email or password is incorrect!"));	
				
		Utils.TakeScreenshot.saveScreen(driver, testCaseName);
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
