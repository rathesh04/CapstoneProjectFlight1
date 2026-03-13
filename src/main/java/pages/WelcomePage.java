package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WelcomePage {	
		
	WebDriver driver;
		
		public WelcomePage(WebDriver driver) throws InterruptedException {
			this.driver = driver;	
		}
		public void choosedepature(String City) throws InterruptedException  {
			WebElement dep = driver.findElement(By.name("fromPort")); 
	        dep.click();
	        Thread.sleep(2000);
	        
			Select DropDown = new Select(driver.findElement(By.name("fromPort")));//drop - down menu
			DropDown.selectByVisibleText(City);
			Thread.sleep(2000);
		}
		public void choosedestination(String City) throws InterruptedException  {
			WebElement dest = driver.findElement(By.name("toPort"));
	        dest.click();
	        Thread.sleep(2000);
	        
			Select DropDown1 = new Select(driver.findElement(By.name("toPort")));//drop - down menu
			DropDown1.selectByVisibleText(City);
			Thread.sleep(2000);
		}
		public void findflight(){
			driver.findElement(By.xpath("//input[@value='Find Flights']")).click(); //clicking find - flight button
		}
		
}


