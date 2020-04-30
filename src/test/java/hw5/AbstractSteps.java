package hw5;

import hw5.site.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class AbstractSteps implements Constants {

    protected SoftAssert softAssert;
    protected WebDriver chromeDriver;
    protected WebDriverWait wait;
    protected IndexPage indexPage;

    public AbstractSteps() {

        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        wait = new WebDriverWait(chromeDriver, WAIT_TIMEOUT);
        indexPage = PageFactory.initElements(chromeDriver, IndexPage.class);
        softAssert = new SoftAssert();
    }

    public void openSiteByURL(String url) {

        chromeDriver.get(url);
    }

    public void siteTitleShouldBe(String expectedTitle) {

        String ret = chromeDriver.getTitle();
        assertEquals(ret, expectedTitle);
    }

    public void login(String userName, String password) {

        indexPage.login(userName, password);
    }

    public void usernameShouldBe(String expectedUsername) {

        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).getText();
        assertEquals(result, expectedUsername);
    }

    public void closeDriver() {

        chromeDriver.close();
    }
}
