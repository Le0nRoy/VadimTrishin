package hw3;

import hw3.site.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class BaseTestClass implements Constants {

    protected WebDriverWait wait;
    protected SoftAssert softAssert;

    protected IndexPage indexPage = new IndexPage();

    @BeforeTest
    protected void beforeTestMethod() {

        indexPage.setup();
        softAssert = new SoftAssert();
        wait = new WebDriverWait(indexPage.getChromeDriver(), WAIT_TIMEOUT);
    }

    @AfterTest
    protected void closeChrome() {

        indexPage.closeChrome();
    }

//    @Test
    protected void openSiteByURLAndCheckItsTitleTest() {

        indexPage.open();

        String ret = indexPage.getChromeDriver().getTitle();
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
