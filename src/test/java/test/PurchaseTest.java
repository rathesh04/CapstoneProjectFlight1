package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.*;

public class PurchaseTest {

    @Test
    public void purchasedetailstest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        WelcomePage welcome = new WelcomePage(driver);

        welcome.choosedepature("Boston");
        welcome.choosedestination("London");
        welcome.findflight();

        ChooseFlightPage choose = new ChooseFlightPage(driver);
        choose.chooseflight();

        PurchasePage purchase = new PurchasePage(driver);

        purchase.passengerDetails("Rathesh Prabu","Valluvar Street","Chennai","Tamil Nadu", "600106");
        purchase.paymentDetails("American Express","1234-5678", "Rathesh Prabu");
        purchase.confirmPurchase();

        driver.quit();
    }
}