package hw3.ex2;

import hw3.BaseTestClass;
import hw3.site.DifferentElementsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class Exercise2 extends BaseTestClass {

    @Test
    @Parameters({"userName", "password"})
    private void exerciseTest(String userName, String password) {

        // Tasks 1 - 2
        openSiteByURLAndCheckItsTitleTest();

        // Tasks 3 - 4
        loginAndCheckUsername(userName, password);

        // Task 5
        DifferentElementsPage page = PageFactory.initElements(chromeDriver, DifferentElementsPage.class);
        page.open();
        DifferentElementsPage.CheckboxesObject checkboxObject = page.getCheckboxesObject();
        DifferentElementsPage.RadioButtonsObject radioButtonsObject = page.getRadioButtonsObject();
        DifferentElementsPage.ColorsSelectObject colorsSelectObject = page.getColorsSelectObject();
        DifferentElementsPage.InfoPanelObject infoPanelObject = page.getInfoPanelObject();

        // Task 6
        ArrayList<String> expectedOptionsCheckboxes = new ArrayList<String>(Arrays.asList(
                "Water",
                "Wind"
        ));
        for (String option : expectedOptionsCheckboxes) {
            checkboxObject.clickCheckbox(option);
        }

        // Task 7
        ArrayList<String> expectedOptionsRadioButtons = new ArrayList<String>(Arrays.asList(
                "Selen"
        ));
        for (String option : expectedOptionsRadioButtons) {
            radioButtonsObject.selectRadioButton(option);
        }

        // Task 8
        ArrayList<String> expectedOptionsSelectables = new ArrayList<String>(Arrays.asList(
                "Yellow"
        ));
        for (String option : expectedOptionsSelectables) {
            colorsSelectObject.selectColor(option);
        }

        // Task 9
        for (String expectedOption : expectedOptionsCheckboxes) {
            softAssert.assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "condition changed to true"));
            softAssert.assertTrue(checkboxObject.isCheckboxSelected(expectedOption));
        }
        for (String expectedOption : expectedOptionsRadioButtons) {
            softAssert.assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "metal"));
            softAssert.assertTrue(radioButtonsObject.isRadioButtonSelected(expectedOption));
        }
        for (String expectedOption : expectedOptionsSelectables) {
            softAssert.assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "Colors"));
            softAssert.assertTrue(colorsSelectObject.isColorSelected(expectedOption));
        }
    }

}
