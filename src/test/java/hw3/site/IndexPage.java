package hw3.site;

import hw3.Constants;

import hw3.PageComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class IndexPage implements Constants {

    protected WebDriverWait wait;
    private NavigationHeaderObject navigationHeaderObject;
    private LeftMenuObject leftMenuObject;
    private BenefitIconsObject benefitIconsObject;
    private BenefitTextsObject benefitTextsObject;
    private FrameButtonObject frameButtonObject;

    public IndexPage(WebDriver driver) {

        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        navigationHeaderObject = new NavigationHeaderObject(driver);
        leftMenuObject = new LeftMenuObject(driver);
        benefitIconsObject = new BenefitIconsObject(driver);
        benefitTextsObject = new BenefitTextsObject(driver);
        frameButtonObject = new FrameButtonObject(driver);
    }

    public NavigationHeaderObject getNavigationHeaderObject() {

        return navigationHeaderObject;
    }
    public LeftMenuObject getLeftMenuObject() {

        return leftMenuObject;
    }
    public BenefitIconsObject getBenefitIconsObject() {

        return benefitIconsObject;
    }
    public BenefitTextsObject getBenefitTextsObject() {

        return benefitTextsObject;
    }
    public FrameButtonObject getFrameButtonObject() {

        return frameButtonObject;
    }

    public void login(String userName, String password) {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul//li//a[@href='#']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("name"))).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("password"))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
    }

    public class NavigationHeaderObject extends PageComponent {

        @FindBy(css = ".navbar-nav > li > a")
        private List<WebElement> navigationHeaderItems;
        public NavigationHeaderObject(WebDriver driver) {

            super(driver);
        }
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

    }

    public class LeftMenuObject extends PageComponent {

        @FindBy(css = ".sidebar-menu span")
        private List<WebElement> leftMenuItems;
        public LeftMenuObject(WebDriver driver) {

            super(driver);
        }
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

    }

    public class BenefitIconsObject extends PageComponent {

        @FindBy(className = "benefit-icon")
        private List<WebElement> benefitIcons;
        public BenefitIconsObject(WebDriver driver) {

            super(driver);
        }
        public List<WebElement> getbenefitIcons() {

            return benefitIcons;
        }

    }

    public class BenefitTextsObject extends PageComponent {

        @FindBy(className = "benefit-txt")
        private List<WebElement> benefitTexts;
        public BenefitTextsObject(WebDriver driver) {

            super(driver);
        }
        public List<WebElement> getBenefitTexts() {

            return benefitTexts;
        }

    }

    public class FrameButtonObject extends PageComponent {

        @FindBy(xpath = "//*[@id='frame'][contains(@src,'frame-button')]")
        private WebElement frameButton;
        public FrameButtonObject(WebDriver driver) {

            super(driver);
        }
        public WebElement getFrameButton() {

            return frameButton;
        }

    }

}
