package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.WelcomePage;

public class WelcomeTest {
	
	@Test
	public void WelcomePageTest1() throws InterruptedException{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.get("https://blazedemo.com/");
		
		WelcomePage w = new WelcomePage(driver);
		
		w.choosedepature("Boston");
		w.choosedestination("London");
		w.findflight();
		
		
		driver.quit();
		}
}
