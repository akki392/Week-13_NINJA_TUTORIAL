package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    public void selectMyAccountOptions (String option) {
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='"+option+"']"));
    }


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(200);
        selectMyAccountOptions("Register");
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Register Account']"), "Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(200);
        selectMyAccountOptions("Login");
        verifyTheStringMessage(By.xpath("//h2[normalize-space()='Returning Customer']"), "Returning Customer");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(200);
        selectMyAccountOptions("Register");
        sendTextToElement(By.name("firstname"), "Akash");
        sendTextToElement(By.name("lastname"), "Dalwadi");
        sendTextToElement(By.id("input-email"), "akashdalwadi1992@gmail.com");
        sendTextToElement(By.name("telephone"), "07545407175");
        sendTextToElement(By.xpath("//input[@id='input-password']"), "akash@1234");
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "akash@1234");
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        clickOnElement(By.xpath("//input[@name='agree']"));
        clickOnElement(By.xpath("//input[@value='Continue']"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"), "Your Account Has Been Created!");
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        selectMyAccountOptions("Logout");
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Account Logout']"), "Account Logout");
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(200);
        selectMyAccountOptions("Login");
        sendTextToElement(By.xpath("//input[@id='input-email']"), "akashdalwadi1992@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-password']"), "akash@1234");
        clickOnElement(By.xpath("//input[@value='Login']"));
        verifyTheStringMessage(By.xpath("//h2[normalize-space()='My Account']"), "My Account");
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(200);
        selectMyAccountOptions("Logout");
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Account Logout']"), "Account Logout");
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }

    @After
    public void endTest() {
        closeBrowser();
    }
}
