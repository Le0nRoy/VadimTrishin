package hw5.ex2;

import hw3.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise1Failed extends BaseTestClass {

    @Test
    @Parameters({"userName", "password"})
    private void exerciseTest(String userName, String password) {

        // Tasks 1 - 2
        openSiteByURLAndCheckItsTitleTest();

        // Tasks 3 - 4
        loginAndCheckUsername(userName, password);

        // Task 5
        List<WebElement> elements = indexPage.getNavigationHeaderObject().getnavigationHeaderItems();
        int expectedNumOfElements = 4;
        List<String> expectedNames = new ArrayList<String>(Arrays.asList(
                "Home FAILED",
                "Contact form",
                "Service",
                "Metals & Colors"
        ));
        softAssert.assertEquals(elements.size(), expectedNumOfElements);
        softAssert.assertNotSame(elements, expectedNames);

        softAssert.assertAll();
    }
}
