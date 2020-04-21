package hw4.ex2;

import hw4.BaseTestClass;
import hw4.site.MetalsAndColorsPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Exercise2 extends BaseTestClass {

    @Test
    @Parameters({"userName", "password"})
    private void exerciseTest(String userName, String password) {

        // Tasks 1
        openSiteByURLAndCheckItsTitleTest();

        // Task 2
        loginAndCheckUsername(userName, password);

        // Task 3
        MetalsAndColorsPage metalsAndColorsPage = new MetalsAndColorsPage(chromeDriver);
        metalsAndColorsPage.open();
    }
}
