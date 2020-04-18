package hw3.site;

import hw3.Constants;
import hw3.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class IndexPage extends PageObject implements Constants {

    protected WebDriverWait wait;

    public IndexPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }

    public void open() {

        driver.get(TEST_SITE_URL);
    }

    public void login(String userName, String password) {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul//li//a[@href='#']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("name"))).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("password"))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
    }

    @FindBy(css = ".navbar-nav > li > a")
    private List<WebElement> navigationHeaderItems;
    public List<WebElement> getnavigationHeaderItems() {

        return navigationHeaderItems;
    }
    public void clickHeaderItem(final String headerItem) {

        for (WebElement el : navigationHeaderItems) {
            if (headerItem.equals(el.getText())) {
                el.click();
                break;
            }
        }
    }

    @FindBy(css = ".sidebar-menu span")
    private List<WebElement> leftMenuItems;
    public List<WebElement> getLeftMenuItems() {

        return leftMenuItems;
    }
    public void clickMenuItem(final String menuItem) {

        for (WebElement el : leftMenuItems) {
            if (menuItem.equals(el.getText())) {
                el.click();
                break;
            }
        }
    }

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;
    public List<WebElement> getbenefitIcons() {

        return benefitIcons;
    }

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitTexts;
    public List<WebElement> getBenefitTexts() {

        return benefitTexts;
    }

    @FindBy(xpath = "//*[@id='frame'][contains(@src,'frame-button')]")
    private WebElement frameButton;
    public WebElement getFrameButton() {

        return frameButton;
    }
}
