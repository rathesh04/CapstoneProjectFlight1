package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class E2ETest5 {

    @Test
    public void purchasedetailstest() throws InterruptedException {
    	   System.out.println("End to End Testing Started");

        WebDriver driver = new ChromeDriver();
        System.out.println("Browser launched successfully");

        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();
        System.out.println("1.Navigated to BlazeDemo website");

        WelcomePage1 welcome = new WelcomePage1(driver);

        welcome.choosedepature("Boston");
        System.out.println("2.Departure city selected");
        welcome.choosedestination("London");
        System.out.println("3.Destination city selected");
        welcome.findflight();
        System.out.println("4.Find Flights button clicked");
        
        ChooseFlightPage2 choose = new ChooseFlightPage2(driver);
        boolean flightsVisible = choose.verifyFlightsDisplayed();
        Assert.assertTrue(flightsVisible);
        System.out.println("5.Flights list displayed successfully");


        ChooseFlightPage2 choose1 = new ChooseFlightPage2(driver);
        choose1.chooseflight();
        System.out.println("6.Flight selected successfully");


        PurchaseDetailsPage3 purchase = new PurchaseDetailsPage3(driver);

        purchase.passengerDetails("Rathesh Prabu","Valluvar Street","Chennai","Tamil Nadu", "600106");
        System.out.println("8.Passenger details entered");
        purchase.paymentDetails("American Express","1234-5678", "Rathesh Prabu");
        System.out.println("9.Payment details entered");
        purchase.confirmPurchase();
        System.out.println("10.Purchase confirmed");
        
        
        ConfirmationPage4 confirm = new ConfirmationPage4(driver);

        Assert.assertTrue(confirm.confirmation());
        System.out.println("11.Confirmation page verified successfully");
        System.out.println("Flight booking completed successfully");
        
        driver.quit();
        System.out.println("Browser closed");

        System.out.println("End to End Testing Started");
    }
}