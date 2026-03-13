package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import pages.*;
import utils.ExcelUtils;

public class E2ETest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        System.out.println("Opening Browser");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/");

        System.out.println("1.Navigated to BlazeDemo website");
    }

    @Test(dataProvider = "passengerData")
    public void flightBookingTest(String name, String address, String city, String state, String zip) throws Exception {

        // Welcome Page
        WelcomePage w = new WelcomePage(driver);

        w.choosedepature("Boston");
        System.out.println("2.Departure city selected");

        w.choosedestination("London");
        System.out.println("3.Destination city selected");

        w.findflight();
        System.out.println("4.Find Flights button clicked");

        // Choose Flight Page
        ChooseFlightPage choose = new ChooseFlightPage(driver);

        boolean flightsVisible = choose.verifyFlightsDisplayed();
        Assert.assertTrue(flightsVisible);
        System.out.println("5.Flights list displayed successfully");

        choose.chooseflight();
        System.out.println("6.Choose This Flight selected successfully");

        // Purchase Page
        PurchasePage purchase = new PurchasePage(driver);

        System.out.println("7.Purchase flight page displayed with flight details");

        // Personal Details from Excel
        purchase.passengerDetails(name, address, city, state, zip);
        System.out.println("8.Personal details entered successfully");

        // Payment Details
        purchase.paymentDetails("American Express", "12345678", name);
        System.out.println("9.Payment details entered successfully");

        purchase.confirmPurchase();
        System.out.println("10.Purchase Flight Clicked");

        // Confirmation Page
        ConfirmationPage confirm = new ConfirmationPage(driver);

        Assert.assertTrue(confirm.confirmation());
        confirm.takeScreenshot(name);
        System.out.println("11.Flight booking completed successfully");
    }

    @DataProvider(name = "passengerData")
    public Object[][] getData() throws Exception {

        return ExcelUtils.getExcelData();
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

        System.out.println("Browser Closed");
    }
}