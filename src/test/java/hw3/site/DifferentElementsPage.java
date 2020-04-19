package hw3.site;

import hw3.Constants;
import hw3.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

public class DifferentElementsPage extends PageObject implements Constants {

    protected WebDriverWait wait;

    public DifferentElementsPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }

    public void open() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Service')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//../*[contains(text(),'Different elements')]"))).click();
    }

    @FindBy(className = "label-checkbox")
    List<WebElement> checkboxes;
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

    @FindBy(className = "label-radio")
    List<WebElement> radioButtons;
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

    @FindBy(xpath = "//*[@class='colors']")
    WebElement colorsSelect;
//    public List<WebElement> getColorsSelect() {
//
//        return select.getOptions();
//    }
    public void selectColor(String colorName) {

        Select select = new Select(colorsSelect.findElement(By.tagName("select")));
        colorsSelect.click();
        select.selectByVisibleText(colorName);
    }

    @FindBy(xpath = "//*[@class='info-panel-section']//li")
    List<WebElement> infoPanel;
    public List<WebElement> getInfoPanel() {

        return infoPanel;
    }

}
