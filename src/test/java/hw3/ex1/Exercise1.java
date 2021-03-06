package hw3.ex1;

import hw3.BaseTestClass;
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

        // FIXME PageComponent
        // Task 5
        List<WebElement> elements = indexPage.getNavigationHeaderObject().getnavigationHeaderItems();
        int expectedNumOfElements = 4;
        List<String> expectedNames = new ArrayList<String>(Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors"
        ));
        softAssert.assertEquals(elements.size(), expectedNumOfElements);
        softAssert.assertNotSame(elements, expectedNames);

        // FIXME PageComponent
        // Task 6
        elements = indexPage.getBenefitIconsObject().getbenefitIcons();
        int expectedNumOfImages = 4;
        softAssert.assertEquals(elements.size(), expectedNumOfImages);

        // FIXME PageComponent
        // Task 7
        elements = indexPage.getBenefitTextsObject().getBenefitTexts();
        int expectedNumOfTextsUnderImages = 4;
        softAssert.assertEquals(elements.size(), expectedNumOfTextsUnderImages);

        // FIXME PageComponent
        // Task 8
        WebElement frameButton = indexPage.getFrameButtonObject().getFrameButton();
        String result = frameButton.getAttribute("src");
        String expected = "https://jdi-testing.github.io/jdi-light/frame-button.html";
        softAssert.assertEquals(result, expected);

        // FIXME PageComponent
        // Task 9
        chromeDriver.get(chromeDriver.findElement(
                By.xpath("//*[@id='frame']")).getAttribute("src"));
        frameButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@value='Frame Button']")));
        result = frameButton.getAttribute("value");
        expected = "Frame Button";
        softAssert.assertEquals(result, expected);

        // Task 10
        openSiteByURLAndCheckItsTitleTest();

        // FIXME PageComponent
        // Task 11
        elements = indexPage.getLeftMenuObject().getLeftMenuItems();
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
