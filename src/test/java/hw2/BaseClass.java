package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BaseClass {

    final protected int WAIT_TIMEOUT = 10;
    protected WebDriver chromeDriver;
    protected WebDriverWait wait;

    private String testSiteURL = "https://jdi-testing.github.io/jdi-light/index.html";

    @Test(enabled = false)
    public void openSiteByURLAndCheckItsTitleTest() {

        chromeDriver.get(testSiteURL);
        String ret = chromeDriver.getTitle();
        String expected = "Home Page";
        assertEquals(ret, expected);
    }

    @Test(enabled = false)
    public void loginAndCheckUsername() {

        chromeDriver.get(testSiteURL);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul//li//a[@href='#']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Roman");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Jdi1234");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();

        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).getText();
        String expected = "ROMAN IOVLEV";

        assertEquals(result, expected);
    }

    @BeforeSuite
    protected void setupChromeDriver() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected void openNewChrome() {

        chromeDriver = new ChromeDriver();
        wait = new WebDriverWait(chromeDriver, WAIT_TIMEOUT);
        chromeDriver.manage().window().maximize();
//        chromeDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT, TimeUnit.SECONDS);
    }

    @AfterMethod
    protected void closeChrome() {

        chromeDriver.quit();
    }

}
