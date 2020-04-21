package hw4.site;

import hw4.Constants;
import hw4.PageComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TableWithPagesPage implements Constants {

    protected WebDriverWait wait;
    protected ShowEntriesSelectObject showEntriesSelectObject;
    protected TableWithPagesObject tableWithPagesObject;

    public TableWithPagesPage(WebDriver driver) {

        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        showEntriesSelectObject = new ShowEntriesSelectObject(driver);
        tableWithPagesObject = new TableWithPagesObject(driver);
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
    public TableWithPagesObject getTableWithPagesObject() {

        return tableWithPagesObject;
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
        public void selectValue(String value) {

            Select select = new Select(showEntriesSelect);
            select.selectByValue(value);
        }
    }

    public class TableWithPagesObject extends PageComponent {

        @FindBy(css = "#table-with-pages")
        WebElement table;
        protected TableWithPagesObject(WebDriver driver) {

            super(driver);
        }

        public List<WebElement> getTableRows() {

            return table.findElements(By.cssSelector("tbody > tr"));
        }
    }
}
