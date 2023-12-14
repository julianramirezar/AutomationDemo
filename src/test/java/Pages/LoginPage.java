package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	// Web Elements
	@FindBy(xpath="//input[@data-qa='signup-name']")
	WebElement signupName;
		
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement signupEmail;
	
	@FindBy(xpath="//div[@class='signup-form']/form/button")
	WebElement signupButton;
	
	// Constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	public void setSignUpName(String name){
		signupName.sendKeys(name);
	}

	public void setSignUpEmail(String email) {
		signupEmail.sendKeys(email);	
	}
	
	public void clickSignUpButton() {
		signupButton.click();
	}
	
}
