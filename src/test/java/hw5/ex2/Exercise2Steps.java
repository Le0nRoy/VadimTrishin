package hw5.ex2;

import hw5.AbstractSteps;
import hw5.site.DifferentElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Exercise2Steps extends AbstractSteps {

    private DifferentElementsPage page;
    private DifferentElementsPage.SelectableElementComponent checkboxObject;
    private DifferentElementsPage.SelectableElementComponent radiobuttonObject;
    private DifferentElementsPage.SelectableElementComponent colorsSelectObject;
    private DifferentElementsPage.InfoPanelObject infoPanelObject;

    Exercise2Steps() {

        super();
        page = PageFactory.initElements(chromeDriver, DifferentElementsPage.class);
        checkboxObject = page.getCheckboxesObject();
        radiobuttonObject = page.getRadioButtonsObject();
        colorsSelectObject = page.getColorsSelectObject();
        infoPanelObject = page.getInfoPanelObject();
    }

    @Step("Open \"Different Elements\" page")
    public void openDifferentElementsPage() {

        page.open();
    }

    @Step("Select checkboxes '{0}")
    public void selectCheckboxOptions(List<String> options) {

        for (String option : options) {
            checkboxObject.selectElement(option);
        }
    }

    @Step("Select radiobutton '{0}")
    public void selectRadiobutton(String option) {

        radiobuttonObject.selectElement(option);
    }

    @Step("Select color '{0}")
    public void selectColor(String option) {

        colorsSelectObject.selectElement(option);
    }

    @Step("Check that checkboxes '{0}' are selected")
    public void checkboxesAreSelected(List<String> expectedOptions) {

        for (String expectedOption : expectedOptions) {
            softAssert.assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "condition changed to true"));
            softAssert.assertTrue(checkboxObject.isElementSelected(expectedOption));
        }
    }

    @Step("Check that radiobutton '{0}' is selected")
    public void radiobuttonIsSelected(String expectedOption) {

        softAssert.assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "metal"));
        softAssert.assertTrue(radiobuttonObject.isElementSelected(expectedOption));
    }

    @Step("Check that color '{0}' is selected")
    public void colorIsSelected(String expectedOption){

        softAssert.assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "Colors"));
        softAssert.assertTrue(colorsSelectObject.isElementSelected(expectedOption));
    }

}
