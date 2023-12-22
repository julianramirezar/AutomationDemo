package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	// Web Elements
	@FindBy(linkText="Signup / Login")	WebElement navbarLogin;	
	@FindBy(id="slider-carousel")	WebElement sliderCarousel;
	@FindBy(xpath="//div[@class='col-sm-8']/div/ul/li[10]")	WebElement loggedInAs;
	@FindBy(linkText="Delete Account")	WebElement deleteAccount;
	@FindBy(linkText="Logout")	WebElement logOut;
	@FindBy(linkText="Contact us")	WebElement ContactUs;
	@FindBy(linkText="Home")	WebElement Home;
	
	// Constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	public WebElement navbarLogin(){
		return navbarLogin;
	}	
	public WebElement sliderCarousel() {
		return sliderCarousel;
	}	
	public WebElement loggedInAs() {
		return loggedInAs;
	}
	public WebElement deleteAccount() {
		return deleteAccount;
	}
	public WebElement logOut() {
		return logOut;
	}
	public WebElement ContactUs() {
		return ContactUs;
	}
	public WebElement Home() {
		return Home;
	}
}
