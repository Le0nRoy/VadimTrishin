package hw4.site;

import hw4.PageComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationHeaderObject extends PageComponent {

    @FindBy(css = ".navbar-nav > li > a")
    private List<WebElement> navigationHeaderItems;
    public NavigationHeaderObject(WebDriver driver) {

        super(driver);
    }
    public List<WebElement> getNavigationHeaderItems() {

        return navigationHeaderItems;
    }
    public void clickHeaderItem(final String headerItem) {

        for (WebElement el : navigationHeaderItems) {
            if (headerItem.equals(el.getText())) {
                el.click();
                return;
            }
        }
    }
}