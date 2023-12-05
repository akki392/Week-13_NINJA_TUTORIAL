package laptopsandnotebooks;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

import java.util.Random;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        Thread.sleep(200);
        mouseHoverOnElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        Thread.sleep(200);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        verifyTheListIsAscedingOrder(By.xpath("//p[@class = 'price']"));
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        Thread.sleep(500);
        mouseHoverOnElementAndClick(By.xpath("//span[normalize-space()='Currency']"));
        mouseHoverOnElementAndClick(By.xpath("//button[normalize-space()='£Pound Sterling']"));
        Thread.sleep(200);
        mouseHoverOnElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='MacBook']"), "MacBook");
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        verifyTheStringMessage(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have added MacBook to your shopping cart!");
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        verifyTheStringMessage(By.xpath("//h1[contains(text(),'Shopping Cart')]"), "Shopping Cart");
        verifyTheStringMessage(By.xpath("//div[@class = 'table-responsive']/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "MacBook");
        String s = Keys.CONTROL + "a";
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), s);
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        clickOnElement(By.xpath("(//button[@type='submit'])[1]"));
        verifyTheStringMessage(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have modified your shopping cart!");
        verifyTheStringMessage(By.xpath("//div[@class = 'table-responsive']/table[1]/tbody[1]/tr[1]/td[6]"), "£737.45");
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Checkout']"), "Checkout");
        verifyTheStringMessage(By.xpath("//h2[normalize-space()='New Customer']"), "New Customer");
        clickOnElement(By.xpath("//input[@value='guest']"));
        clickOnElement(By.xpath("//input[@id='button-account']"));
        sendTextToElement(By.name("firstname"), "Akash");
        sendTextToElement(By.name("lastname"), "Dalwadi");
        Random random = new Random();
        sendTextToElement(By.id("input-payment-email"), "akashdalwadi1992"+random.nextInt()+"@gmail.com");
        sendTextToElement(By.name("telephone"), "07545407175");
        sendTextToElement(By.name("address_1"), "84 Northwick Avenue");
        sendTextToElement(By.name("city"), "London");
        sendTextToElement(By.name("postcode"), "HA3 0AT");
        selectByVisibleTextFromDropDown(By.name("country_id"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.name("zone_id"), "Essex");
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "The product is Good.");
        clickOnElement(By.xpath("//input[@name='agree']"));
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        verifyTheStringMessage(By.xpath("//div[@class='alert alert-danger alert-dismissible']"), "Warning: Payment method required!");
    }

    @After
    public void endTest() {
        closeBrowser();
    }
}
