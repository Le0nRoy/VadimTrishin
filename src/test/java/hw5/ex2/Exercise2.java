package hw5.ex2;

import hw5.AbstractBaseTest;
import hw5.site.DifferentElementsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise2 extends AbstractBaseTest {

    Exercise2Steps steps;

    @BeforeTest
    private void setupSteps() {

        abstractSteps = new Exercise2Steps();
        steps = (Exercise2Steps) abstractSteps;
    }

    @Test
    @Parameters({"userName", "password"})
    private void exerciseTest(String userName, String password) {

        // Tasks 1 - 2
        steps.openSiteByURL(TEST_SITE_URL);
        String expected = "Home Page";
        steps.siteTitleShouldBe(expected);

        // Tasks 3 - 4
        steps.login(userName, password);
        expected = "ROMAN IOVLEV";
        steps.usernameShouldBe(expected);
//
//        // Task 5
//        DifferentElementsPage page = PageFactory.initElements(chromeDriver, DifferentElementsPage.class);
//        page.open();
//        DifferentElementsPage.SelectableElementComponent checkboxObject = page.getCheckboxesObject();
//        DifferentElementsPage.SelectableElementComponent radioButtonsObject = page.getRadioButtonsObject();
//        DifferentElementsPage.SelectableElementComponent colorsSelectObject = page.getColorsSelectObject();
//        DifferentElementsPage.InfoPanelObject infoPanelObject = page.getInfoPanelObject();
//
//        // Task 6
//        ArrayList<String> expectedOptionsCheckboxes = new ArrayList<String>(Arrays.asList(
//                "Water",
//                "Wind"
//        ));
//        for (String option : expectedOptionsCheckboxes) {
//            checkboxObject.selectElement(option);
//        }
//
//        // Task 7
//        ArrayList<String> expectedOptionsRadioButtons = new ArrayList<String>(Arrays.asList(
//                "Selen"
//        ));
//        for (String option : expectedOptionsRadioButtons) {
//            radioButtonsObject.selectElement(option);
//        }
//
//        // Task 8
//        ArrayList<String> expectedOptionsSelectables = new ArrayList<String>(Arrays.asList(
//                "Yellow"
//        ));
//        for (String option : expectedOptionsSelectables) {
//            colorsSelectObject.selectElement(option);
//        }
//
//        // Task 9
//        for (String expectedOption : expectedOptionsCheckboxes) {
//            softAssert.assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "condition changed to true"));
//            softAssert.assertTrue(checkboxObject.isElementSelected(expectedOption));
//        }
//        for (String expectedOption : expectedOptionsRadioButtons) {
//            softAssert.assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "metal"));
//            softAssert.assertTrue(radioButtonsObject.isElementSelected(expectedOption));
//        }
//        for (String expectedOption : expectedOptionsSelectables) {
//            softAssert.assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "Colors"));
//            softAssert.assertTrue(colorsSelectObject.isElementSelected(expectedOption));
//        }
    }

}
