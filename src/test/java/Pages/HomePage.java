package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	// Web Elements
	@FindBy(linkText="Signup / Login")
	WebElement navbarLogin;
	
	// Constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	public void clickLogin(){
		navbarLogin.click();
	}
	
	
	
}
