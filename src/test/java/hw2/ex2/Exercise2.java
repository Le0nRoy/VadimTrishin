package hw2.ex2;

import hw2.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.*;

public class Exercise2 extends BaseClass {

    @Test
    private void selectCheckboxesAndAssertTheirStatuses() {

        switchToServiceDifferentElements();
        List<WebElement> elements = chromeDriver.findElements(By.xpath("//*[@class='label-checkbox']"));
        String[] expectedOptions = {"Water", "Wind"};

        assertEquals(elements.size(), 4);
        for (Iterator<WebElement> iterator = elements.iterator(); iterator.hasNext(); ) {
            WebElement el = iterator.next();
            if ( (el.getText().equals(expectedOptions[0])) || (el.getText().equals(expectedOptions[1])) ) {
                el.click();
            }
        }

        elements = chromeDriver.findElements(By.xpath("//*[@class='info-panel-section']//li"));

        assertEquals(elements.size(), 2);
        for (Iterator<WebElement> iterator = elements.iterator(); iterator.hasNext(); ) {
            WebElement el = iterator.next();
            if (el.getText().contains(expectedOptions[0])) {
                assertTrue(el.getText().contains("condition changed to true"));
            }
            if (el.getText().contains(expectedOptions[1])) {
                assertTrue(el.getText().contains("condition changed to true"));
            }
        }
    }

    @Test
    private void selectRadiobuttonsAndAssertTheirStatusses() {

        switchToServiceDifferentElements();
        List<WebElement> elements = chromeDriver.findElements(By.xpath("//*[@class='label-radio']"));
        String expectedOption = "Selen";

        assertEquals(elements.size(), 4);
        for (Iterator<WebElement> iterator = elements.iterator(); iterator.hasNext(); ) {
            WebElement el = iterator.next();
            if ( el.getText().equals(expectedOption) ) {
                el.click();
            }
        }

        elements = chromeDriver.findElements(By.xpath("//*[@class='info-panel-section']//li"));

        assertEquals(elements.size(), 1);
        for (Iterator<WebElement> iterator = elements.iterator(); iterator.hasNext(); ) {
            WebElement el = iterator.next();
            if (el.getText().contains("metal")) {
                assertTrue(el.getText().contains("value changed to " + expectedOption));
            }
        }
    }

    @Test
    private void selectInDropdownAndAssertItsStatus() {

        switchToServiceDifferentElements();
        chromeDriver.findElement(By.xpath("//*[@class='colors']")).click();
        String expectedOption = "Yellow";

        List<WebElement> elements = chromeDriver.findElements(By.xpath("//*[@class='colors']//option"));
        for (Iterator<WebElement> iterator = elements.iterator(); iterator.hasNext(); ) {
            WebElement el = iterator.next();
            if (el.getText().equals(expectedOption)) {
                el.click();
            }
        }

        elements = chromeDriver.findElements(By.xpath("//*[@class='info-panel-section']//li"));

        assertEquals(elements.size(), 1);
        for (Iterator<WebElement> iterator = elements.iterator(); iterator.hasNext(); ) {
            WebElement el = iterator.next();
            if (el.getText().contains("colors")) {
                assertTrue(el.getText().contains("value changed to " + expectedOption));
            }
        }
    }

    private void switchToServiceDifferentElements() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//*[contains(text(),'Service')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//../*[contains(text(),'Different elements')]"))).click();
    }

}
