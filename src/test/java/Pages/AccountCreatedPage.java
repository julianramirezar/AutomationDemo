package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
	
	// Web Elements
	@FindBy(id="form")	WebElement accountCreated;
	@FindBy(linkText="Continue")	WebElement continueButton;
	
	// Constructor
	public AccountCreatedPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}		
	
	public WebElement accountCreated() {
		return accountCreated;
	}
	public void clickContinueButton() {
		continueButton.click();
	}

}
