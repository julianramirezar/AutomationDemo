package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage {
	
	// Web Elements
	@FindBy(id="form")	WebElement accountDeleted;
	@FindBy(linkText="Continue")	WebElement continueButton;
	
	// Constructor
	public AccountDeletedPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}		
	
	public WebElement accountDeleted() {
		return accountDeleted;
	}
	public void clickContinueButton() {
		continueButton.click();
	}

}
