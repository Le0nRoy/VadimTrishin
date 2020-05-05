package hw5.ex1;

import hw5.AbstractSteps;
import hw5.site.DifferentElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertTrue;

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
            assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "condition changed to true"));
        }
    }

    @Step("Check that radiobutton '{0}' is selected")
    public void radiobuttonIsSelected(String expectedOption) {

        assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "metal"));
    }

    @Step("Check that color '{0}' is selected")
    public void colorIsSelected(String expectedOption){

        assertTrue(infoPanelObject.findStringInInfoPanelByTwoPatterns(expectedOption, "Colors"));
    }

}
