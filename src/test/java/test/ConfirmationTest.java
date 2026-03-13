package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class ConfirmationTest {

    @Test
    public void purchasedetailstest() throws Exception {

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
        
        ConfirmationPage confirm = new ConfirmationPage(driver);
        if (confirm.confirmation()) {

            confirm.takeScreenshot("confirmation_page");
            System.out.println("Purchase Successful");

        } else {

            System.out.println("Purchase Failed");
        }
        Assert.assertTrue(confirm.confirmation());

        driver.quit();
    }
}