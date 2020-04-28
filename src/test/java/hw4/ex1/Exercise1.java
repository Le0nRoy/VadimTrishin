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
        int expected = 5;
        softAssert.assertEquals(Integer.parseInt(defaultNumOfEntries), expected);

        // Task 11
        expected = 10;
        showEntriesSelectObject.selectValue(Integer.toString(expected));
        String currentNumOfEntries = showEntriesSelectObject.getCurrentState();
        softAssert.assertEquals(Integer.parseInt(currentNumOfEntries), expected);

        // Task 13
        TableWithPagesPage.TableWithPagesObject tableWithPagesObject = tableWithPagesPage.getTableWithPagesObject();
        List<WebElement> tableRows = tableWithPagesObject.getTableRows();
        int numOfRows = tableRows.size();
        expected = 10;
        softAssert.assertEquals(numOfRows, expected);

        //Tasks 14 - 15
        TableWithPagesPage.TableFilterObject tableFilterObject = tableWithPagesPage.getTableFilterObject();
        String searchText = "junit";
        tableFilterObject.searchByText(searchText);

        tableRows = tableWithPagesObject.getTableRows();
        for (WebElement el : tableRows) {
            softAssert.assertTrue(el.getText().toLowerCase().contains(searchText));
        }

        softAssert.assertAll();
    }
}
