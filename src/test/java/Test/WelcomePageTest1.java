package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.WelcomePage1;

public class WelcomePageTest1 {
	
	@Test
	public void WelcomePageTest1() throws InterruptedException{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.get("https://blazedemo.com/");
		
		WelcomePage1 w = new WelcomePage1(driver);
		
		w.choosedepature("Boston");
		w.choosedestination("London");
		w.findflight();
		
		
		driver.quit();
		}
}
