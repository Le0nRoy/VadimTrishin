package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

    protected WebDriver chromeDriver;

    @BeforeSuite
    protected void setupChromeDriver() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected void openNewChrome() {
        chromeDriver = new ChromeDriver();
    }

    @AfterMethod
    protected void closeChrome() {
        chromeDriver.quit();
    }

}
