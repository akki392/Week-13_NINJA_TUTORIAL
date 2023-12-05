package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String  getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    public void mouseHoverOnElement(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    public void mouseHoverOnElementAndClick(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public void selectByVisibleTextFromDropDown(By by, String value) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }

    public boolean verifyTheListIsDescendingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isDecending = false;

        for (int i = 0; i < list.size()-1; i++) {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) < 0) {
                isDecending=true;
            }
        }
        return isDecending;
    }
    public boolean verifyTheListIsAscedingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isAsceding = false;

        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) > 0) {
                isAsceding=true;
            }
        }
        return isAsceding;
    }
    public void verifyTheStringMessage(By by, String actualMessage) {
        String expected = getTextFromElement(by);
        String expectedString = expected.substring(0, actualMessage.length());
        Assert.assertEquals(expectedString,actualMessage);
    }



}
