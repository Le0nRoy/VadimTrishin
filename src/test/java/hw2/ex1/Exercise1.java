package hw2.ex1;

import hw2.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class Exercise1 extends BaseClass {

    @Test
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

    @Test
    private void checkImagesOnIndexPage() {

        List<WebElement> elements = chromeDriver.findElements(By.className("benefit-icon"));

        int expectedNumOfImages = 4;

        assertEquals(elements.size(), expectedNumOfImages);
    }

    @Test
    private void checkTextsOnIndexPage() {

        List<WebElement> elements = chromeDriver.findElements(By.className("benefit-txt"));

        int expectedNumOfTexts = 4;

        assertEquals(elements.size(), expectedNumOfTexts);
    }

    @Test
    private void checkExistanceOfIFrame() {

        WebElement frameButton = chromeDriver.findElement(By.xpath("//*[@id='frame'][contains(@src,'frame-button')]"));

        String result = frameButton.getAttribute("src");
        String expected = "https://jdi-testing.github.io/jdi-light/frame-button.html";

        assertEquals(result, expected);
    }

    @Test
    private void switchToIFrameAndCheckItsContents() {

        chromeDriver.get(chromeDriver.findElement(By.xpath("//*[@id='frame']")).getAttribute("src"));
        WebElement frameButton = chromeDriver.findElement(By.xpath("//*[@value='Frame Button']"));

        String result = frameButton.getAttribute("value");
        String expected = "Frame Button";

        assertEquals(result, expected);
    }

    @Test
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

}
