package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {

    static String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){
        WebElement menulink = driver.findElement(By.xpath(menu));
        menulink.click();
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        Thread.sleep(200);
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Desktops']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        verifyTheStringMessage(By.tagName("h2"), "Desktops");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        Thread.sleep(200);
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        verifyTheStringMessage(By.tagName("h2"), "Laptops & Notebooks");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        Thread.sleep(200);
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Components']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllComponents']"));
        verifyTheStringMessage(By.tagName("h2"), "Components");
    }

    @After
    public void endTest() {
        closeBrowser();
    }

}
