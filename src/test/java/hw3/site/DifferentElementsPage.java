package hw3.site;

import hw3.Constants;
import hw3.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
