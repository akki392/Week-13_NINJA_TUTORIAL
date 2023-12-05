package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        Thread.sleep(200);
        mouseHoverOnElementAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        Thread.sleep(200);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        verifyTheListIsDescendingOrder(By.tagName("h4"));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        Thread.sleep(500);
        mouseHoverOnElementAndClick(By.xpath("//span[normalize-space()='Currency']"));
        mouseHoverOnElementAndClick(By.xpath("//button[normalize-space()='£Pound Sterling']"));
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Desktops']"));
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='HP LP3065']"), "HP LP3065");
        datePicker("28", "Nov","2023");
        String s = Keys.CONTROL + "a";
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), s);
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        verifyTheStringMessage(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have added HP LP3065 to your shopping cart!");
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        verifyTheStringMessage(By.xpath("//h1[contains(text(),'Shopping Cart')]"), "Shopping Cart");
        verifyTheStringMessage(By.xpath("//table[@class = 'table table-bordered']/tbody[1]/tr[1]/td[2]/a[1]"),"HP LP3065");
        verifyTheStringMessage(By.xpath("//table[@class = 'table table-bordered']//small[1]"), "Delivery Date:2023-11-28");
        verifyTheStringMessage(By.xpath("//td[normalize-space()='Product 21']"), "Product 21");
        verifyTheStringMessage(By.cssSelector("tbody tr td:nth-child(6)"), "£74.73");
    }

    public void datePicker(String day, String month, String year) throws InterruptedException {
        clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));
        clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@colspan='5']"));

        while(true){
            String y = getTextFromElement(By.xpath("//div[@class='datepicker-months'] //th[@class='picker-switch']"));
            if(y.equalsIgnoreCase(year)){
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-months']//th[@class='next'][contains(text(),'›')]"));
            }
        }
        clickOnElement(By.xpath("//span[normalize-space()='"+month+"']"));
        Thread.sleep(200);
        clickOnElement(By.xpath("//td[@class = 'day' and text() = '"+day+"']"));
    }

    @After
    public void endTest() {
        closeBrowser();
    }



}

