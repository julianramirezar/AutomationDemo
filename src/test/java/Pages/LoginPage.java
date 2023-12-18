package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	// Web Elements
	@FindBy(xpath="//input[@data-qa='signup-name']")	WebElement signupName;		
	@FindBy(xpath="//input[@data-qa='signup-email']")	WebElement signupEmail;		
	@FindBy(xpath="//input[@data-qa='login-email']")	WebElement loginEmail;	
	@FindBy(xpath="//input[@data-qa='login-password']")	WebElement loginPassword;	
	@FindBy(xpath="//div[@class='signup-form']/form/button")	WebElement signupButton;	
	@FindBy(xpath="//div[@class='login-form']/form/button")	WebElement logInButton;
	@FindBy(className="signup-form")	WebElement signupForm;
	@FindBy(className="login-form")	WebElement loginForm;	
	
	// Constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement signupForm() {
		return signupForm;
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
	public WebElement loginForm() {
		return loginForm;
	}
	public void sendLoginEmail(String email){
		loginEmail.sendKeys(email);
	}
	public void sendLoginPassword(String password){
		loginPassword.sendKeys(password);
	}
	public void clickLogInButton() {
		logInButton.click();
	}
	public void logIn(String email, String password) {
		sendLoginEmail(email);
		sendLoginPassword(password);
		clickLogInButton();
	}	
}
