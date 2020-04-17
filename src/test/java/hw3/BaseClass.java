package hw3;

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

    protected WebDriver chromeDriver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;
    protected IndexPage indexPage = new IndexPage();

    protected class IndexPage {

        final protected String TEST_SITE_URL = "https://jdi-testing.github.io/jdi-light";
        final protected int WAIT_TIMEOUT = 5;

        public void setup() {

            WebDriverManager.chromedriver().setup();
            chromeDriver = new ChromeDriver();
            chromeDriver.manage().window().maximize();

            softAssert = new SoftAssert();
            wait = new WebDriverWait(chromeDriver, WAIT_TIMEOUT);
        }

        public void open() {

            chromeDriver.get(TEST_SITE_URL);
        }

        public void login(String userName, CharSequence password) {

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul//li//a[@href='#']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("name"))).sendKeys(userName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("password"))).sendKeys(password);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
        }

    }

    @BeforeTest
    protected void beforeTestMethod() {

        indexPage.setup();
    }

    @AfterTest
    protected void closeChrome() {

        chromeDriver.quit();
    }

    protected void openSiteByURLAndCheckItsTitleTest() {

        indexPage.open();

        String ret = chromeDriver.getTitle();
        String expected = "Home Page";

        // Using here strong assert because some tests are dependent on this one
        assertEquals(ret, expected);
    }

    protected void loginAndCheckUsername(String userName, CharSequence password) {

        indexPage.login(userName, password);

        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).getText();
        String expected = "ROMAN IOVLEV";

        // Using here strong assert because some tests are dependent on this one
        assertEquals(result, expected);
    }



}
