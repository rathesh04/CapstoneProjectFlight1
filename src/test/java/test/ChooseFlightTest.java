package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.WelcomePage;
import pages.ChooseFlightPage;

public class ChooseFlightTest {

    @Test
    public void chooseflighttest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        WelcomePage w = new WelcomePage(driver);

        w.choosedepature("Boston");
        w.choosedestination("London");
        w.findflight();
        
        ChooseFlightPage choose = new ChooseFlightPage(driver);
        boolean flightsVisible = choose.verifyFlightsDisplayed();

        Assert.assertTrue(flightsVisible, "Flights list not displayed");
        choose.chooseflight();

        driver.quit();
    }
}