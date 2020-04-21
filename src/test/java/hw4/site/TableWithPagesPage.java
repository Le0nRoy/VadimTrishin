package hw4.site;

import hw4.Constants;
import hw4.PageComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableWithPagesPage implements Constants {

    protected WebDriverWait wait;
    protected ShowEntriesSelectObject showEntriesSelectObject;

    public TableWithPagesPage(WebDriver driver) {

        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        showEntriesSelectObject = new ShowEntriesSelectObject(driver);
    }

    public void open() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Service')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//../*[contains(text(),'Table with pages')]"))).click();
    }

    public ShowEntriesSelectObject getShowEntriesSelectObject() {
        return showEntriesSelectObject;
    }

    public class ShowEntriesSelectObject extends PageComponent {

        @FindBy(css = "select.uui-form-element")
        private WebElement showEntriesSelect;

        protected ShowEntriesSelectObject(WebDriver driver) {

            super(driver);
        }

        public String getCurrentState() {
            return showEntriesSelect.getText();
        }
    }
}
