package hw4.ex1;

import com.google.common.collect.Table;
import hw4.BaseTestClass;
import hw4.site.TableWithPagesPage;
import javafx.scene.control.Tab;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

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
    }
}
