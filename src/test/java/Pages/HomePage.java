package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	// Web Elements
	@FindBy(name="search_query")
	WebElement queryBox;
	
	@FindBy(name="submit_search")
	WebElement submitQuery;
	
	// Constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	public void clickSubmitSearch(){
		submitQuery.click();
	}
	
}
