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
import Pages.ContactUsPage;
import Pages.HomePage;

public class TC6ContactUs {
	String url = "http://automationexercise.com";
	String testCaseName = MethodHandles.lookup().lookupClass().getSimpleName();
	String name = "Test Contact";
	String email = "tc6contact@example.com";
	String subject = "Test Subject";
	String message = "Test Message";
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void ContactUs() {
		HomePage home = new HomePage(driver);

		// Verify that home page is visible successfully
		Assert.assertTrue(home.sliderCarousel().isDisplayed());

		// Verify 'GET IN TOUCH' is visible
		home.ContactUs().click();
		ContactUsPage contact = new ContactUsPage(driver);
		Assert.assertTrue(contact.contactForm().isDisplayed());
		Assert.assertTrue(contact.contactForm().getText().contains("GET IN TOUCH"));

		// Verify success message 'Success! Your details have been submitted
		// successfully.' is visible
		contact.sendContact(name, email, subject, message);
		driver.switchTo().alert().accept();
		Assert.assertTrue(
				contact.contactForm().getText().contains("Success! Your details have been submitted successfully."));
		driver.navigate().refresh();

		// Click 'Home' button and verify that landed to home page successfully*
		home.Home().click();
		home.Home().click();
		//driver.navigate().refresh();
		Assert.assertTrue(home.sliderCarousel().isDisplayed());
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
