package hw4.ex1;

import hw4.BaseTestClass;
import hw4.site.TableWithPagesPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Exercise1 extends BaseTestClass {

    @Test
    @Parameters({"userName", "password"})
    private void exerciseTest(String userName, String password) {

        // Tasks 1 - 2
        openSiteByURLAndCheckItsTitleTest();

        // Tasks 3 - 4
        loginAndCheckUsername(userName, password);

        // Task 7
        TableWithPagesPage tableWithPagesPage = PageFactory.initElements(chromeDriver, TableWithPagesPage.class);
        tableWithPagesPage.open();

        // Task 8
        TableWithPagesPage.ShowEntriesSelectObject showEntriesSelectObject = tableWithPagesPage.getShowEntriesSelectObject();
        String defaultNamOfEntries = showEntriesSelectObject.getCurrentState();
        // FIXME deal with quotes and check ints
        String expected = "\"5";
        softAssert.assertEquals(defaultNamOfEntries, expected);
    }
}
