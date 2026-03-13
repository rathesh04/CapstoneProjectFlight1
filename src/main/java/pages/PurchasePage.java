package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PurchasePage {

    WebDriver driver;
    public PurchasePage(WebDriver driver) {
        this.driver = driver;
    }
    public void passengerDetails(String name, String address, String city,String state, String zip) throws InterruptedException {

        driver.findElement(By.id("inputName")).sendKeys(name);
        Thread.sleep(2000);

        driver.findElement(By.id("address")).sendKeys(address);
        Thread.sleep(2000);

        driver.findElement(By.id("city")).sendKeys(city);
        Thread.sleep(2000);

        driver.findElement(By.id("state")).sendKeys(state);
        Thread.sleep(2000);

        driver.findElement(By.id("zipCode")).sendKeys(zip);
        Thread.sleep(2000);

        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
    }

    public void paymentDetails(String cardType, String cardNumber,String nameOnCard) throws InterruptedException {
    	
    	WebElement cardDropdown = driver.findElement(By.id("cardType"));
    	cardDropdown.click(); 
    	Thread.sleep(2000);

        Select drop = new Select(driver.findElement(By.id("cardType")));
        drop.selectByVisibleText(cardType);

        Thread.sleep(2000);

        driver.findElement(By.id("creditCardNumber")).sendKeys(cardNumber);
        Thread.sleep(2000);
        
        driver.findElement(By.id("creditCardMonth")).clear();
        driver.findElement(By.id("creditCardMonth")).sendKeys("27");
        Thread.sleep(2000);

        driver.findElement(By.id("creditCardYear")).clear();
        driver.findElement(By.id("creditCardYear")).sendKeys("2026");
        Thread.sleep(2000);

        driver.findElement(By.id("nameOnCard")).sendKeys(nameOnCard);
        Thread.sleep(2000);
    }

    public void confirmPurchase() throws InterruptedException {

        WebElement checkbox = driver.findElement(By.id("rememberMe"));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click(); //click purchase flight button

        Thread.sleep(2000);
    }
}