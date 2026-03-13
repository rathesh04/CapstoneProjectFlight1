package pages;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

public class ConfirmationPage {
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean confirmation() {
		return driver.getPageSource().contains("Thank you for your purchase today!");	
	}
	public void takeScreenshot(String name) throws Exception {

	    TakesScreenshot ts = (TakesScreenshot) driver;

	    File src = ts.getScreenshotAs(OutputType.FILE);
	    String filename = "screenshots/" + name + "_" + System.currentTimeMillis() + ".png";
	    File dest = new File(filename);
	    FileHandler.copy(src, dest);
	    System.out.println("Screenshot saved: " + filename);
	}

}
