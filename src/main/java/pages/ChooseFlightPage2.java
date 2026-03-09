package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseFlightPage2 {
	
	WebDriver driver;
	
	public ChooseFlightPage2(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyFlightsDisplayed() {

        boolean result = driver.getPageSource().contains("Flights from");

        return result;
    }

	
	public void chooseflight() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[1]/input")).click();
		
	}
	

}
