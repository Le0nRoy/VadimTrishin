package hw3.site;

import hw3.Constants;
import hw3.PageComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

public class DifferentElementsPage implements Constants {

    protected WebDriverWait wait;
    private CheckboxesObject checkboxesObject;
    private RadioButtonsObject radioButtonsObject;
    private ColorsSelectObject colorsSelectObject;
    private InfoPanelObject infoPanelObject;

    public DifferentElementsPage(WebDriver driver) {

        wait = new WebDriverWait(driver, WAIT_TIMEOUT);

        checkboxesObject = new CheckboxesObject(driver);
        radioButtonsObject = new RadioButtonsObject(driver);
        colorsSelectObject = new ColorsSelectObject(driver);
        infoPanelObject = new InfoPanelObject(driver);
    }

    public void open() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Service')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//../*[contains(text(),'Different elements')]"))).click();
    }

    public CheckboxesObject getCheckboxesObject() {

        return checkboxesObject;
    }
    public RadioButtonsObject getRadioButtonsObject() {

        return radioButtonsObject;
    }
    public ColorsSelectObject getColorsSelectObject() {

        return colorsSelectObject;
    }
    public InfoPanelObject getInfoPanelObject() {

        return infoPanelObject;
    }

    public class CheckboxesObject extends PageComponent {

        @FindBy(className = "label-checkbox")
        List<WebElement> checkboxes;
        public CheckboxesObject(WebDriver driver) {

            super(driver);
        }
        public List<WebElement> getCheckboxes() {

            return checkboxes;
        }
        public void clickCheckbox(String checkboxName) {

            for (Iterator<WebElement> iterator = checkboxes.iterator(); iterator.hasNext(); ) {
                WebElement el = iterator.next();
                if (el.getText().equals(checkboxName)) {
                    el.click();
                    break;
                }
            }
        }
        public boolean isCheckboxSelected(String checkboxName) {

            for (Iterator<WebElement> iterator = checkboxes.iterator(); iterator.hasNext(); ) {
                WebElement el = iterator.next();
                if (el.getText().equals(checkboxName)) {
                    return el.isSelected();
                }
            }
            return false;
        }

    }

    public class RadioButtonsObject extends PageComponent {

        @FindBy(className = "label-radio")
        List<WebElement> radioButtons;
        public RadioButtonsObject(WebDriver driver) {

            super(driver);
        }
        public List<WebElement> getRadioButtons() {

            return radioButtons;
        }
        public void selectRadioButton(String radioButtonName) {

            for (Iterator<WebElement> iterator = radioButtons.iterator(); iterator.hasNext(); ) {
                WebElement el = iterator.next();
                if (el.getText().equals(radioButtonName)) {
                    el.click();
                    break;
                }
            }
        }
        public boolean isRadioButtonSelected(String radioButtonName) {

            for (Iterator<WebElement> iterator = radioButtons.iterator(); iterator.hasNext(); ) {
                WebElement el = iterator.next();
                if (el.getText().equals(radioButtonName)) {
                    return el.isSelected();
                }
            }
            return false;
        }
    }

    public class ColorsSelectObject extends PageComponent {

        @FindBy(xpath = "//*[@class='colors']")
        WebElement colorsSelect;
        public ColorsSelectObject(WebDriver driver) {

            super(driver);
        }
        public List<WebElement> getColorsSelect() {

            Select select = new Select(colorsSelect.findElement(By.tagName("select")));
            return select.getOptions();
        }
        public void selectColor(String colorName) {

            Select select = new Select(colorsSelect.findElement(By.tagName("select")));
            colorsSelect.click();
            select.selectByVisibleText(colorName);
        }
        public boolean isColorSelected(String colorName) {

            if (colorsSelect.getText().equals(colorName)) {
                return true;
            }
            return false;
        }
    }

    public class InfoPanelObject extends PageComponent {

        @FindBy(xpath = "//*[@class='info-panel-section']//li")
        List<WebElement> infoPanel;
        public InfoPanelObject(WebDriver driver) {

            super(driver);
        }
        public List<WebElement> getInfoPanel() {

            return infoPanel;
        }
        public boolean findStringInInfoPanelByTwoPatterns(String pattern1, String pattern2) {

            for (Iterator<WebElement> iterator = infoPanel.iterator(); iterator.hasNext(); ) {
                WebElement el = iterator.next();
                if (el.getText().contains(pattern1) && el.getText().contains(pattern2)) {
                    return true;
                }
            }
            return false;
        }
    }
}
