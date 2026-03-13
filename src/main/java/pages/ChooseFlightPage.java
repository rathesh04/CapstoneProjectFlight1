package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseFlightPage {
	
	WebDriver driver;
	
	public ChooseFlightPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyFlightsDisplayed() {

        boolean result = driver.getPageSource().contains("Flights from");
        return result; //Verify that a list of available flights is displayed
    }

	
	public void chooseflight() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[1]/input")).click();
		
	}
	

}
