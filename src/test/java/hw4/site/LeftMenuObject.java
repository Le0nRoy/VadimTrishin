package hw4.site;

import hw4.PageComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
