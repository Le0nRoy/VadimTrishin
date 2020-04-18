package hw3.ex1;

import hw3.BaseTestClass;
import hw3.site.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise1 extends BaseTestClass {

    @Test
    @Parameters({"userName", "password"})
    private void exerciseTest(String userName, String password) {

        // Tasks 1 - 2
        openSiteByURLAndCheckItsTitleTest();

        // Tasks 3 - 4
        loginAndCheckUsername(userName, password);

        // Task 5
        IndexPage.PageComponents pageComponents = indexPage.new PageComponents();

        List<WebElement> elements = pageComponents.getHeaderMenu().getnavigationHeaderItems();

        int expectedNumOfElements = 4;
        List<String> expectedNames = new ArrayList<String>(Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors"
        ));

        softAssert.assertEquals(elements.size(), expectedNumOfElements);
        softAssert.assertNotSame(elements, expectedNames);

        // fixme refactor
        // Task 6
        elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.className("benefit-icon")));
        int expectedNumOfImages = 4;
        softAssert.assertEquals(elements.size(), expectedNumOfImages);

        // fixme refactor
        // Task 7
        elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.className("benefit-txt")));
        int expectedNumOfTextsUnderImages = 4;
        softAssert.assertEquals(elements.size(), expectedNumOfTextsUnderImages);

        // fixme refactor
        // Task 8
        WebElement frameButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='frame'][contains(@src,'frame-button')]")));
        String result = frameButton.getAttribute("src");
        String expected = "https://jdi-testing.github.io/jdi-light/frame-button.html";
        softAssert.assertEquals(result, expected);

        // fixme refactor
        // Task 9
        indexPage.getChromeDriver().get(indexPage.getChromeDriver().findElement(
                By.xpath("//*[@id='frame']")).getAttribute("src"));
        frameButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@value='Frame Button']")));
        result = frameButton.getAttribute("value");
        expected = "Frame Button";
        softAssert.assertEquals(result, expected);

        // Task 10
        indexPage.open();
        openSiteByURLAndCheckItsTitleTest();

        // Task 11
        elements = pageComponents.getLeftSideMenu().getLeftMenuItems();
//        elements = chromeDriver.findElements(
//                By.cssSelector(".sidebar-menu span"));

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
