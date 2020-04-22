package hw4.ex2;

import hw4.BaseTestClass;
import hw4.site.MetalsAndColorsPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Exercise2 extends BaseTestClass {

    @Test
    @Parameters({"userName", "password"})
    private void exerciseTest(String userName, String password) {

        // Tasks 1
        openSiteByURLAndCheckItsTitleTest();

        // Task 2
        loginAndCheckUsername(userName, password);

        // Task 3
        navigationHeaderObject.clickHeaderItem("Metals & Colors");
        MetalsAndColorsPage metalsAndColorsPage = new MetalsAndColorsPage(chromeDriver);

        // Task 4
        metalsAndColorsPage.getSummaryObject().clickElement("5");
        metalsAndColorsPage.getSummaryObject().clickElement("6");
        metalsAndColorsPage.getElementsObject().clickElement("Water");
        metalsAndColorsPage.getColorsObject().selectByValue("Yellow");
        metalsAndColorsPage.getMetalsObject().selectByValue("Selen");
        metalsAndColorsPage.getVegetablesObject().selectByValue("Onion");

        // Task 5
        metalsAndColorsPage.getSubmitButton().clickButton();

        // Task 6
        List<String> results = metalsAndColorsPage.getResultSection().getTextFromSection();
        List<String> resultsPattern = Arrays.asList(
                "Summary: ",
                "Elements: ",
                "Color: ",
                "Metal: ",
                "Vegetables: "
        );
        assertEquals(results.size(), resultsPattern.size());
        for (int i = 0; i < resultsPattern.size(); ++i) {
            softAssert.assertTrue(results.get(i).contains(resultsPattern.get(i)));
        }

        softAssert.assertAll();
    }
}
