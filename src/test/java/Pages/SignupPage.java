package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utils.User;

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
	@FindBy(id="address1")	WebElement address1Field;
	@FindBy(id="address2")	WebElement address2Field;
	@FindBy(id="country")	WebElement countryField;
	@FindBy(id="state")	WebElement stateField;
	@FindBy(id="city")	WebElement cityField;
	@FindBy(id="zipcode")	WebElement zipCodeField;
	@FindBy(id="mobile_number")	WebElement mobileField;
	@FindBy(xpath="//div[@class='login-form']/form/button")	WebElement createAccountButton;	
		
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
	public void setDay(String day) {
		Select setDay = new Select(dayField);
		setDay.selectByVisibleText(day);
	}	
	public void setMonth(String month) {
		Select setMonth = new Select(monthField);
		setMonth.selectByVisibleText(month);
	}	
	public void setYear(String year) {
		Select setYear = new Select(yearField);
		setYear.selectByVisibleText(year);
	}	
	public void setFirstName(String firstName) {
		firstNameField.clear();
		firstNameField.sendKeys(firstName);	
	}
	public void setLastName(String lastName) {
		lastNameField.clear();
		lastNameField.sendKeys(lastName);	
	}	
	public void setCompany(String company) {
		companyField.clear();
		companyField.sendKeys(company);	
	}		
	public void newsletterCheck() {
		newsletterCheck.click();
	}
	public void offersCheck() {
		offersCheck.click();
	}
	public void setAddress1(String address1) {
		address1Field.clear();
		address1Field.sendKeys(address1);	
	}	
	public void setAddress2(String address2) {
		address2Field.clear();
		address2Field.sendKeys(address2);	
	}	
	public void setCountry(int country) {
		Select setCountry = new Select(countryField);
		setCountry.selectByIndex(country);
	}	
	public void setState(String state) {
		stateField.clear();
		stateField.sendKeys(state);	
	}	
	public void setCity(String city) {
		cityField.clear();
		cityField.sendKeys(city);	
	}	
	public void setZipCode(String zipCode) {
		zipCodeField.clear();
		zipCodeField.sendKeys(zipCode);	
	}	
	public void setMobile(String mobile) {
		mobileField.clear();
		mobileField.sendKeys(mobile);	
	}	
	public void clickCreateAccount() {
		createAccountButton.click();
	}
	public void createAccount(User newUser) {
		
		/*
		String gender, String username, String password, String day,
		String month, String year, String firstName, String lastName,
		String company, String address1, String address2, String country, 
		String state, String City, String zipCode, String mobile
		*/
		
		if (newUser.getGender() == "M"){
			clickGenderMale();
		}
		else {
			clickGenderFemale();
		}
		setUsername(newUser.getUsername());
		setPassword(newUser.getPassword());
		setDay(newUser.getDay());
		setMonth(newUser.getMonth());
		setYear(newUser.getYear());
		setFirstName(newUser.getFirstName());
		setLastName(newUser.getLastName());
		setCompany(newUser.getPassword());
		newsletterCheck();
		offersCheck();
		setAddress1(newUser.getAddress1());
		setAddress2(newUser.getAddress2());
		setCountry(newUser.getCountry());
		setState(newUser.getState());
		setCity(newUser.getCity());
		setZipCode(newUser.getZipCode());
		setMobile(newUser.getMobile());
		createAccountButton.click();
	}	
}