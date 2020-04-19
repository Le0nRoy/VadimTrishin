package hw3.ex2;

import hw3.BaseTestClass;
import hw3.site.DifferentElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class Exercise2 extends BaseTestClass {

    @Test
    @Parameters({"userName", "password"})
    private void exerciseTest(String userName, String password) {

        // Tasks 1 - 2
        openSiteByURLAndCheckItsTitleTest();

        // Tasks 3 - 4
        loginAndCheckUsername(userName, password);

        // Task 5
        DifferentElementsPage page = PageFactory.initElements(chromeDriver, DifferentElementsPage.class);
        page.open();

        // Task 6
        ArrayList<String> expectedOptionsCheckboxes = new ArrayList<String>(Arrays.asList(
                "Water",
                "Wind"
        ));
        for (String option : expectedOptionsCheckboxes) {
            page.clickCheckbox(option);
        }

        // Task 7
        ArrayList<String> expectedOptionsRadioButtons = new ArrayList<String>(Arrays.asList(
                "Selen"
        ));
        for (String option : expectedOptionsRadioButtons) {
                page.selectRadioButton(option);
        }

        // Task 8
        ArrayList<String> expectedOptionsSelectables = new ArrayList<String>(Arrays.asList(
                "Yellow"
        ));
        for (String option : expectedOptionsSelectables) {
            page.selectColor(option);
        }

        // Fixme Refactor to PageComponents
        // Task 9
        List<WebElement> elements = chromeDriver.findElements(By.xpath("//*[@class='info-panel-section']//li"));

        for (Iterator<WebElement> iterator = elements.iterator(); iterator.hasNext(); ) {
            WebElement el = iterator.next();
            for (String expectedOption : expectedOptionsCheckboxes) {
                if (el.getText().contains(expectedOption)) {
                    assertTrue(el.getText().contains("condition changed to true"));
                }
            }
            if (el.getText().contains("metal")) {
                for (String expectedOption : expectedOptionsRadioButtons) {
                    assertTrue(el.getText().contains("value changed to " + expectedOption));
                }
            }

            if (el.getText().contains("colors")) {
                for (String expectedOption : expectedOptionsSelectables) {
                    assertTrue(el.getText().contains("value changed to " + expectedOption));
                }
            }
        }
    }

}
