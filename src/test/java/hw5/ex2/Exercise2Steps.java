package hw5.ex2;

import hw5.AbstractSteps;
import hw5.site.DifferentElementsPage;
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

    public void openDifferentElementsPage() {

        page.open();
    }

    public void selectCheckboxOptions(List<String> options) {

        for (String option : options) {
            checkboxObject.selectElement(option);
        }
    }

    public void selectRadiobutton(String option) {

        radiobuttonObject.selectElement(option);
    }

    public void selectColor(String option) {

        colorsSelectObject.selectElement(option);
    }

    public void checkboxesAreSelected(List<String> expectedOptions) {

        for (String expectedOption : expectedOptions) {
            softAssert.assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "condition changed to true"));
            softAssert.assertTrue(checkboxObject.isElementSelected(expectedOption));
        }
    }

    public void radiobuttonIsSelected(String expectedOption) {

        softAssert.assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "metal"));
        softAssert.assertTrue(radiobuttonObject.isElementSelected(expectedOption));
    }

    public void colorIsSelected(String expectedOption){

        softAssert.assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "Colors"));
        softAssert.assertTrue(colorsSelectObject.isElementSelected(expectedOption));
    }

}
