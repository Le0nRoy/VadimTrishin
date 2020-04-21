package hw4;

import hw4.site.IndexPage;
import hw4.site.LeftMenuObject;
import hw4.site.NavigationHeaderObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class BaseTestClass implements Constants {

    protected WebDriver chromeDriver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;

    protected IndexPage indexPage;
    protected NavigationHeaderObject navigationHeaderObject;
    protected LeftMenuObject leftMenuObject;

    @BeforeTest
    protected void beforeTestMethod() {

        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        softAssert = new SoftAssert();
        wait = new WebDriverWait(chromeDriver, WAIT_TIMEOUT);

        indexPage = PageFactory.initElements(chromeDriver, IndexPage.class);
        navigationHeaderObject = PageFactory.initElements(chromeDriver, NavigationHeaderObject.class);
        leftMenuObject = PageFactory.initElements(chromeDriver, LeftMenuObject.class);
    }

    @AfterTest
    protected void closeChrome() {

        chromeDriver.close();
    }

    protected void openSiteByURLAndCheckItsTitleTest() {

        chromeDriver.get(TEST_SITE_URL);

        String ret = chromeDriver.getTitle();
        String expected = "Home Page";

        // Using here strong assert because some tests are dependent on this one
        assertEquals(ret, expected);
    }

    protected void loginAndCheckUsername(String userName, String password) {

        indexPage.login(userName, password);

        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).getText();
        String expected = "ROMAN IOVLEV";

        // Using here strong assert because some tests are dependent on this one
        assertEquals(result, expected);
    }

}
