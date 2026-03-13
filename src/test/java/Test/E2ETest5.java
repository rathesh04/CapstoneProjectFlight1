package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.*;

public class E2ETest5 {

    WebDriver driver; //declare WebDriver reference

    @BeforeMethod
    public void setup() {

        System.out.println("Opening Browser");

        driver = new ChromeDriver(); //launch Chrome browser
        driver.manage().window().maximize(); //maximize browser window
        driver.get("https://blazedemo.com/"); //navigate to BlazeDemo website

        System.out.println("1.Navigated to BlazeDemo website");
    }

    @Test
    public void flightBookingTest() throws InterruptedException {

        //create object of WelcomePage to interact with homepage
        WelcomePage1 w = new WelcomePage1(driver);

        //select departure city from dropdown
        w.choosedepature("Boston");
        System.out.println("2.Departure city selected");

        //select destination city from dropdown
        w.choosedestination("London");
        System.out.println("3.Destination city selected");

        //click Find Flights button
        w.findflight();
        System.out.println("4.Find Flights button clicked");

        //create object of ChooseFlightPage
        ChooseFlightPage2 choose = new ChooseFlightPage2(driver);

        //verify list of available flights is displayed
        boolean flightsVisible = choose.verifyFlightsDisplayed();
        Assert.assertTrue(flightsVisible);
        System.out.println("5.Flights list displayed successfully");

        //select one flight
        choose.chooseflight();
        System.out.println("6.Choose This Flight selected successfully");

        //create object of PurchaseDetailsPage
        PurchaseDetailsPage3 purchase = new PurchaseDetailsPage3(driver);

        //verify purchase flight page is displayed
        System.out.println("7.Purchase flight page displayed with flight details");

        //enter passenger personal details
        purchase.passengerDetails("Rathesh Prabu","Valluvar Street","Chennai","Tamil Nadu","600106");
        System.out.println("8.Personal details entered successfully");

        //enter payment details
        purchase.paymentDetails("American Express","12345678","Rathesh Prabu");
        System.out.println("9.Payment details entered successfully");

        //click Purchase Flight button
        purchase.confirmPurchase();
        System.out.println("10.Purchase Flight Clicked");

        //create object of confirmation page
        ConfirmationPage4 confirm = new ConfirmationPage4(driver);

        //verify booking confirmation message
        Assert.assertTrue(confirm.confirmation());
        System.out.println("11.Flight booking completed successfully");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit(); //close the browser

        System.out.println("Browser Closed");
    }
}
