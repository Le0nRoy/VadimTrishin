package hw2.ex2;

import hw2.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.*;

public class Exercise2 extends BaseClass {

    @Test
    private void exerciseTest() {

        // Tasks 1 - 2
        openSiteByURLAndCheckItsTitleTest();

        // Tasks 3 - 4
        loginAndCheckUsername();

        // Task 5
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Service')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//../*[contains(text(),'Different elements')]"))).click();

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
