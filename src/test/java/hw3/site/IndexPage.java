package hw3.site;

import hw3.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class IndexPage implements Constants {

    protected WebDriver chromeDriver;
    protected WebDriverWait wait;

    public class PageComponents {

        private HeaderMenu headerMenu;
        private LeftSideMenu leftSideMenu;

        public PageComponents() {

            headerMenu = new HeaderMenu();
            leftSideMenu = new LeftSideMenu();
        }

        public HeaderMenu getHeaderMenu() {

            return headerMenu;
        }

        public LeftSideMenu getLeftSideMenu() {

            return leftSideMenu;
        }

        public class HeaderMenu {

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

        }

        public class LeftSideMenu {

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
        }
    }

    public void setup() {

        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        wait = new WebDriverWait(chromeDriver, WAIT_TIMEOUT);
    }

    public void open() {

        chromeDriver.get(TEST_SITE_URL);
    }

    public void closeChrome() {

        chromeDriver.quit();
    }

    public void login(String userName, String password) {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul//li//a[@href='#']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("name"))).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("password"))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
    }

    public WebDriver getChromeDriver() {

        return chromeDriver;
    }

}
