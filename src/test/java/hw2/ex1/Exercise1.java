package hw2.ex1;

import hw2.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class Exercise1 extends BaseClass {

    @Test(enabled = false)
//    @Test
    private void checkItemsOnHeader() {

        List<WebElement> elements = chromeDriver.findElements(
                By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li"));

        int expectedNumOfElements = 4;
        List<String> expectedNames = new ArrayList<String>(Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors"
        ));

        assertEquals(elements.size(), expectedNumOfElements);
        assertNotSame(elements, expectedNames);
    }

    @Test(enabled = false)
//    @Test
    private void checkImagesOnIndexPage() {

        List<WebElement> elements = chromeDriver.findElements(By.className("benefit-icon"));

        int expectedNumOfImages = 4;

        assertEquals(elements.size(), expectedNumOfImages);
    }

    @Test(enabled = false)
//    @Test
    private void checkTextsOnIndexPage() {

        List<WebElement> elements = chromeDriver.findElements(By.className("benefit-txt"));

        int expectedNumOfTexts = 4;

        assertEquals(elements.size(), expectedNumOfTexts);
    }

    @Test(enabled = false)
//    @Test
    private void checkExistanceOfIFrame() {

        WebElement frameButton = chromeDriver.findElement(By.xpath("//input[@id='frame-button']"));
//        WebElement frameButton = chromeDriver.findElement(By.xpath("//input[@value='Frame Button']"));
//        WebElement frameButton = chromeDriver.findElement(By.xpath("//iframe//*[@id='frame-button']"));
//        WebElement frameButton = chromeDriver.findElement(By.xpath("//iframe//*[@value='Frame Button']"));
//        List<WebElement> elements = chromeDriver.findElements(By.tagName("iframe"));

//        int numOfElements = elements.size();
//        int numOfExceptions = 0;
//        for (WebElement el : elements) {
////            el.findElement(By.xpath("//input[@id='frame-button']"));
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='frame-button']")));
//        }
//        assertNotEquals(numOfExceptions, numOfElements);
    }

    @Test(enabled = false)
//    @Test
    private void switchToIFrameAndCheckItsContents() {

    }

    @Test(enabled = false)
//    @Test
    private void checkItemsOnLeftSection() {

        List<WebElement> elements = chromeDriver.findElements(By.xpath("//ul[@class='sidebar-menu']/li/a/span"));

        int expectedNumOfElements = 5;
        List<String> expectedNames = new ArrayList<String>(Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors",
                "Elements packs"
        ));

        assertEquals(elements.size(), expectedNumOfElements);
        assertNotSame(elements, expectedNames);
    }

    // FIXME delete after debugging
    @Deprecated
    private void sleep() {

        try {
            Thread.sleep(WAIT_TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
