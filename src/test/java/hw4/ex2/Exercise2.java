package hw4.ex2;

import hw4.BaseTestClass;
import hw4.site.MetalsAndColorsPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
//        metalsAndColorsPage.getColorsObject().selectByValue("Yellow");
//        metalsAndColorsPage.getMetalsObject().selectByValue("Selen");
//        metalsAndColorsPage.getVegetablesObject().selectByValue("Onion");

        // Task 5
        metalsAndColorsPage.getSubmitButton().clickButton();

    }
}
