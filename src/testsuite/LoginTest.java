package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValid Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on
 * page
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {               //Browser open code
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid() {                 //Login test
        driver.findElement(By.id("user-name")).sendKeys("standard_user");                                           //Enter username
        driver.findElement(By.id("password")).sendKeys("secret_sauce");                                             //Enter password
        driver.findElement(By.id("login-button")).click();                                                                     //Click on login button
        String expectedText = "PRODUCTS";
        String actualText = driver.findElement(By.xpath("//span[text()='Products']")).getText().toUpperCase();    //Convert text to upper case
        Assert.assertEquals(expectedText, actualText);                                                                         //Compare 2 strings
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {             //Six products display test
        driver.findElement(By.id("user-name")).sendKeys("standard_user");                               //Enter username
        driver.findElement(By.id("password")).sendKeys("secret_sauce");                                 //Enter password
        driver.findElement(By.id("login-button")).click();                                                         //Click on login button
        List<WebElement> productElement = driver.findElements(By.className("inventory_item"));                     //Count products
        int expectedProducts = 6;
        Assert.assertEquals("User cannot see 6 products.", expectedProducts, productElement.size());      //Compare 2 values
    }

    @After
    public void tearDown() {                    //Browser closing code
        closeBrowser();
    }
}
