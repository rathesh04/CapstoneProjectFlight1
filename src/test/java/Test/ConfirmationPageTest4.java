package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class ConfirmationPageTest4 {

    @Test
    public void purchasedetailstest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        WelcomePage1 welcome = new WelcomePage1(driver);

        welcome.choosedepature("Boston");
        welcome.choosedestination("London");
        welcome.findflight();

        ChooseFlightPage2 choose = new ChooseFlightPage2(driver);
        choose.chooseflight();

        PurchaseDetailsPage3 purchase = new PurchaseDetailsPage3(driver);

        purchase.passengerDetails("Rathesh Prabu","Valluvar Street","Chennai","Tamil Nadu", "600106");
        purchase.paymentDetails("American Express","1234-5678", "Rathesh Prabu");
        purchase.confirmPurchase();
        
        ConfirmationPage4 confirm = new ConfirmationPage4(driver);

        Assert.assertTrue(confirm.confirmation());

        driver.quit();
    }
}