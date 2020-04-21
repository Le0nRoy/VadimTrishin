package hw4.site;

import hw4.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MetalsAndColorsPage implements Constants {

    protected WebDriverWait wait;

    public MetalsAndColorsPage(WebDriver driver) {

        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }

    public void open() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Service')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//../*[contains(text(),'Metals & Colors')]"))).click();
    }
}
