package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class BaseClass {

    final protected int WAIT_TIMEOUT = 10;
    protected WebDriver chromeDriver;
    protected WebDriverWait wait;

    @Test
    public void openSiteByURLAndCheckItsTitleTest() {

        String ret = chromeDriver.getTitle();
        String expected = "Home Page";
        assertEquals(ret, expected);
    }

    @Test
    public void loginAndCheckUsername() {

        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).getText();
        String expected = "ROMAN IOVLEV";

        assertEquals(result, expected);
    }

    @BeforeTest
    protected void setupChromeDriver() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected void openNewChromeWithTestSiteAndLogin() {

        chromeDriver = new ChromeDriver();
        wait = new WebDriverWait(chromeDriver, WAIT_TIMEOUT);
        chromeDriver.manage().window().maximize();
//        chromeDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT, TimeUnit.SECONDS);

        String testSiteURL = "https://jdi-testing.github.io/jdi-light";
        chromeDriver.get(testSiteURL);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul//li//a[@href='#']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Roman");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Jdi1234");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
    }

    @AfterMethod
    protected void closeChrome() {

        chromeDriver.quit();
    }

}
