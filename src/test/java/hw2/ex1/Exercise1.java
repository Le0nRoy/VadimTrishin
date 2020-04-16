package hw2.ex1;

import hw2.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise1 extends BaseClass {

    @Test
    private void exerciseTest() {

        // Tasks 1 - 2
        openSiteByURLAndCheckItsTitleTest();

        // Tasks 3 - 4
        loginAndCheckUsername();

        // Task 5
        List<WebElement> elements = chromeDriver.findElements(
                By.cssSelector(".navbar-nav > li > a"));


        int expectedNumOfElements = 4;
        List<String> expectedNames = new ArrayList<String>(Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors"
        ));

        softAssert.assertEquals(elements.size(), expectedNumOfElements);
        softAssert.assertNotSame(elements, expectedNames);

        // Task 6
        elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.className("benefit-icon")));
        int expectedNumOfImages = 4;
        softAssert.assertEquals(elements.size(), expectedNumOfImages);

        // Task 7
        elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.className("benefit-txt")));
        int expectedNumOfTextsUnderImages = 4;
        softAssert.assertEquals(elements.size(), expectedNumOfTextsUnderImages);

        // Task 8
        WebElement frameButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='frame'][contains(@src,'frame-button')]")));
        String result = frameButton.getAttribute("src");
        String expected = "https://jdi-testing.github.io/jdi-light/frame-button.html";
        softAssert.assertEquals(result, expected);

        // Task 9
        chromeDriver.get(chromeDriver.findElement(By.xpath("//*[@id='frame']")).getAttribute("src"));
        frameButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@value='Frame Button']")));
        result = frameButton.getAttribute("value");
        expected = "Frame Button";
        softAssert.assertEquals(result, expected);

        // Task 10
        chromeDriver.get(TEST_SITE_URL);
        openSiteByURLAndCheckItsTitleTest();

        // Task 11
        elements = chromeDriver.findElements(
                By.cssSelector(".sidebar-menu span"));
        expectedNumOfElements = 5;
        expectedNames = new ArrayList<String>(Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors",
                "Elements packs"
        ));
        softAssert.assertEquals(elements.size(), expectedNumOfElements);
        softAssert.assertNotSame(elements, expectedNames);
    }

}
