package AutomationDemo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
	
	@Test
	public void OpenMainSite() {
		ChromeDriver browser = new ChromeDriver();
		browser.navigate().to("https://www.google.com/");
	}
}
