
package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.*;

public class E2ETest5 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        System.out.println("Opening Browser");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/");

        System.out.println("Navigated to BlazeDemo website");
    }

    @Test
    public void flightBookingTest() throws InterruptedException {

        System.out.println("End to End Testing Started");

        WelcomePage1 w = new WelcomePage1(driver);

        w.choosedepature("Boston");
        w.choosedestination("London");
        w.findflight();

        ChooseFlightPage2 choose = new ChooseFlightPage2(driver);

        boolean flightsVisible = choose.verifyFlightsDisplayed();
        Assert.assertTrue(flightsVisible);

        System.out.println("Flights list displayed successfully");

        choose.chooseflight();

        PurchaseDetailsPage3 purchase = new PurchaseDetailsPage3(driver);

        purchase.passengerDetails("Rathesh Prabu","Valluvar Street","Chennai","Tamil Nadu","600106");
        purchase.paymentDetails("American Express","12345678","Rathesh Prabu");
        purchase.confirmPurchase();

        ConfirmationPage4 confirm = new ConfirmationPage4(driver);

        Assert.assertTrue(confirm.confirmation());

        System.out.println("Flight booking completed successfully");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

        System.out.println("Browser Closed");
    }
}
