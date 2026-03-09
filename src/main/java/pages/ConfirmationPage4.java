package pages;

import org.openqa.selenium.WebDriver;

public class ConfirmationPage4 {
	
	WebDriver driver;
	
	public ConfirmationPage4(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean confirmation() {
		return driver.getPageSource().contains("Thank you for your purchase today!");	
	}
}
