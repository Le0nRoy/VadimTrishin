package hw5;

import hw5.site.IndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

        WebDriverSingleton.INSTANCE.createdDriver("chrome");
        chromeDriver = WebDriverSingleton.INSTANCE.getDriver();
        chromeDriver.manage().window().maximize();
        wait = new WebDriverWait(chromeDriver, WAIT_TIMEOUT);
        indexPage = PageFactory.initElements(chromeDriver, IndexPage.class);
        softAssert = new SoftAssert();
    }

    @Step("Open '{0}' URL.")
    public void openSiteByURL(String url) {

        chromeDriver.get(url);
    }

    @Step("Title of opened site should be '{0}")
    public void siteTitleShouldBe(String expectedTitle) {

        String ret = chromeDriver.getTitle();
        assertEquals(ret, expectedTitle);
    }

    @Step("Login as '{0}' with password '{1}")
    public void login(String userName, String password) {

        indexPage.login(userName, password);
    }

    @Step("Username shold be '{0}")
    public void usernameShouldBe(String expectedUsername) {

        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).getText();
        assertEquals(result, expectedUsername);
    }

    @Step("Close browser driver")
    public void closeDriver() {

        chromeDriver.close();
    }
}
