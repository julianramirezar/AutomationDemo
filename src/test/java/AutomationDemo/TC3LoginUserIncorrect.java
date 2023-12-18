package AutomationDemo;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import Pages.HomePage;
import Pages.LoginPage;

public class TC3LoginUserIncorrect {
	String url = "http://automationexercise.com";
	String incorrectEmail = "incorrectemail@example.com";
	String incorrectPassword = "123pass123";
	WebDriver driver;
			
	@BeforeSuite
	public void setUp() {		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();		
	}	
	
	@Test 
	public void LoginUserIncorrect() {
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
	}	
	
	@AfterSuite
	public void shutDown() {
		driver.close();
	}
}
