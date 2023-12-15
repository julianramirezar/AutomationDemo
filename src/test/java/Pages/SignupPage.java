package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	
	// Web Elements
	@FindBy(className="login-form")	WebElement loginForm;	
	@FindBy(id="id_gender1")	WebElement genderMale;	
	@FindBy(id="id_gender2")	WebElement genderFemale;	
	@FindBy(id="name")	WebElement usernameField;	
	@FindBy(id="email")	WebElement emailField;	
	@FindBy(id="password")	WebElement passwordField;	
	@FindBy(id="days")	WebElement dayField;	
	@FindBy(id="months")	WebElement monthField;	
	@FindBy(id="years")	WebElement yearField;	
	@FindBy(id="newsletter")	WebElement newsletterCheck;	
	@FindBy(id="optin")	WebElement offersCheck;	
	@FindBy(id="first_name")	WebElement firstNameField;	
	@FindBy(id="last_name")	WebElement lastNameField;	
	@FindBy(id="company")	WebElement companyField;
		
	// Constructor
	public SignupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement loginForm() {
		return loginForm;
	}	
	public void clickGenderMale() {
		genderMale.click();
	}	
	public void clickGenderFemale() {
		genderFemale.click();
	}
	public void setUsername(String username) {
		usernameField.clear();
		usernameField.sendKeys(username);	
	}	
	public void setPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);	
	}	
	public void setfirstName(String firstName) {
		firstNameField.clear();
		firstNameField.sendKeys(firstName);	
	}
	public void setlastName(String lastName) {
		lastNameField.clear();
		lastNameField.sendKeys(lastName);	
	}	
	public void setcompany(String company) {
		companyField.clear();
		companyField.sendKeys(company);	
	}		
}