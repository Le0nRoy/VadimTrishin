package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageComponent {

    protected WebDriver driver;

    protected PageComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
