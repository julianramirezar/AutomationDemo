package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
	// Web Elements
	@FindBy(className="contact-form")	WebElement contactForm;	
	@FindBy(xpath="//input[@data-qa='name']")	WebElement contactName;
	@FindBy(xpath="//input[@data-qa='email']")	WebElement contactEmail;
	@FindBy(xpath="//input[@data-qa='subject']")	WebElement contactSubject;
	@FindBy(id="message")	WebElement contactMessage;
	@FindBy(xpath="//input[@data-qa='submit-button']")	WebElement submitButton;
		
	// Constructor
	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	public WebElement contactForm() {
		return contactForm;
	}	
	public WebElement contactName() {
		return contactName;
	}
	public WebElement contactEmail() {
		return contactEmail;
	}
	public WebElement contactSubject() {
		return contactSubject;
	}
	public WebElement contactMessage() {
		return contactMessage;
	}
	public WebElement submitButton() {
		return submitButton;
	}
	public void setContactName(String name) {
		contactName.clear();
		contactName.sendKeys(name);
	}
	public void setContactEmail(String email) {
		contactEmail.clear();
		contactEmail.sendKeys(email);
	}
	public void setContactSubject(String subject) {
		contactSubject.clear();
		contactSubject.sendKeys(subject);
	}
	public void setContactMessage(String message) {
		contactMessage.clear();
		contactMessage.sendKeys(message);
	}
	public void sendContact(String name, String email, String subject, String message) {
		setContactName(name);
		setContactEmail(email);
		setContactSubject(subject);
		setContactMessage(message);
		submitButton.click();
	}
}
