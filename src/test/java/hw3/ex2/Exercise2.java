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

        // FIXME refactor to PageComponents
        // Task 6
        List<WebElement> elements = chromeDriver.findElements(By.className("label-checkbox"));
        ArrayList<String> expectedOptionsCheckboxes = new ArrayList<String>(Arrays.asList(
                "Water",
                "Wind"
        ));

        for (Iterator<WebElement> iterator = elements.iterator(); iterator.hasNext(); ) {
            WebElement el = iterator.next();
            for ( String option : expectedOptionsCheckboxes ) {
                if ( el.getText().equals(option)) {
                    el.click();
                }
            }
        }

        // FIXME refactor to PageComponents
        // Task 7
        elements = chromeDriver.findElements(By.className("label-radio"));
        ArrayList<String> expectedOptionsRadioButtons = new ArrayList<String>(Arrays.asList(
                "Selen"
        ));

        for (Iterator<WebElement> iterator = elements.iterator(); iterator.hasNext(); ) {
            WebElement el = iterator.next();
            for ( String option : expectedOptionsRadioButtons ) {
                if ( el.getText().equals(option)) {
                    el.click();
                }
            }
        }

        // FIXME refactor to PageComponents
        // Task 8
        WebElement element = chromeDriver.findElement(By.xpath("//*[@class='colors']"));
        element.click();
        Select select = new Select(element.findElement(
                By.tagName("select")));
        ArrayList<String> expectedOptionsSelectables = new ArrayList<String>(Arrays.asList(
                "Yellow"
        ));

        for (String option : expectedOptionsSelectables ) {
            select.selectByVisibleText(option);
        }

        // Fixme Refactor to PageComponents
        // Task 9
        elements = chromeDriver.findElements(By.xpath("//*[@class='info-panel-section']//li"));

        for (Iterator<WebElement> iterator = elements.iterator(); iterator.hasNext(); ) {
            WebElement el = iterator.next();
            for (String expectedOption : expectedOptionsCheckboxes ) {
                if (el.getText().contains(expectedOption)) {
                    assertTrue(el.getText().contains("condition changed to true"));
                }
            }
            if (el.getText().contains("metal")) {
                for (String expectedOption : expectedOptionsRadioButtons ) {
                    assertTrue(el.getText().contains("value changed to " + expectedOption));
                }
            }

            if (el.getText().contains("colors")) {
                for (String expectedOption : expectedOptionsSelectables ) {
                    assertTrue(el.getText().contains("value changed to " + expectedOption));
                }
            }
        }
    }
}
