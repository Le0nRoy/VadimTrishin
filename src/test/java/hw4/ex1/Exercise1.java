package hw4.ex1;

import hw4.BaseTestClass;
import hw4.site.TableWithPagesPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

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
        String defaultNumOfEntries = showEntriesSelectObject.getCurrentState();
        // FIXME deal with quotes and check ints
        String expectedString = "\"5";
        softAssert.assertEquals(defaultNumOfEntries, expectedString);

        // Task 11
        int expectedInt = 10;
        showEntriesSelectObject.selectValue(Integer.toString(expectedInt));
        String currentNumOfEntries = showEntriesSelectObject.getCurrentState();
        expectedString = "\"" + expectedInt;
        softAssert.assertEquals(currentNumOfEntries, expectedString);

        // Task 13
        TableWithPagesPage.TableWithPagesObject tableWithPagesObject = tableWithPagesPage.getTableWithPagesObject();
        List<WebElement> tableRows = tableWithPagesObject.getTableRows();
        int numOfRows = tableRows.size();
        expectedInt = 10;
        softAssert.assertEquals(numOfRows, expectedInt);
    }
}
