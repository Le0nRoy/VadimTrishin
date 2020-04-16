package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class BaseClass {

    final protected int WAIT_TIMEOUT = 5;
    final protected String TEST_SITE_URL = "https://jdi-testing.github.io/jdi-light";
    protected WebDriver chromeDriver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;

    protected void openSiteByURLAndCheckItsTitleTest() {

        String ret = chromeDriver.getTitle();
        String expected = "Home Page";
        // Using here strong assert because some tests are dependent on this one
        assertEquals(ret, expected);
    }

    protected void loginAndCheckUsername() {

        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).getText();
        String expected = "ROMAN IOVLEV";
        // Using here strong assert because some tests are dependent on this one
        assertEquals(result, expected);
    }

    @BeforeTest
    protected void setupChromeDriver() {

        WebDriverManager.chromedriver().setup();
        softAssert = new SoftAssert();

        chromeDriver = new ChromeDriver();
        wait = new WebDriverWait(chromeDriver, WAIT_TIMEOUT);
        chromeDriver.manage().window().maximize();

        chromeDriver.get(TEST_SITE_URL);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul//li//a[@href='#']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Roman");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Jdi1234");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
    }

    @AfterTest
    protected void closeChrome() {

        chromeDriver.quit();
    }

}
