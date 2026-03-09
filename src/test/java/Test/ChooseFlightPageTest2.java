package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.WelcomePage1;
import pages.ChooseFlightPage2;

public class ChooseFlightPageTest2 {

    @Test
    public void chooseflighttest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        WelcomePage1 welcome = new WelcomePage1(driver);

        welcome.choosedepature("Boston");
        welcome.choosedestination("London");
        welcome.findflight();
        
        ChooseFlightPage2 choose = new ChooseFlightPage2(driver);
        boolean flightsVisible = choose.verifyFlightsDisplayed();

        Assert.assertTrue(flightsVisible, "Flights list not displayed");
        choose.chooseflight();

        driver.quit();
    }
}