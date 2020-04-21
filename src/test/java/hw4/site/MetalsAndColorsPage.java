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

final public class MetalsAndColorsPage implements Constants {

    private WebDriverWait wait;
    private SummaryObject summaryObject;
    private ElementsObject elementsObject;
    private ColorsObject colorsObject;
    private MetalsObject metalsObject;
    private VegetablesObject vegetablesObject;
    private SubmitButton submitButton;

    public MetalsAndColorsPage(WebDriver driver) {

        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        summaryObject = new SummaryObject(driver);
        elementsObject = new ElementsObject(driver);
        colorsObject = new ColorsObject(driver);
        metalsObject = new MetalsObject(driver);
        vegetablesObject = new VegetablesObject(driver);
        submitButton = new SubmitButton(driver);
    }

    public SummaryObject getSummaryObject() {

        return summaryObject;
    }
    public ElementsObject getElementsObject() {

        return elementsObject;
    }
    public ColorsObject getColorsObject() {

        return colorsObject;
    }
    public MetalsObject getMetalsObject() {

        return metalsObject;
    }
    public VegetablesObject getVegetablesObject() {

        return vegetablesObject;
    }
    public SubmitButton getSubmitButton() {

        return submitButton;
    }

    public class ClickableObject extends PageComponent {

        List<WebElement> elements;

        protected ClickableObject(WebDriver driver) {

            super(driver);
        }

        public void clickElement(String value) {
            for (WebElement el : elements) {
                if (el.getText().equals(value)) {
                    el.click();
                }
            }
        }
    }

    final public class SummaryObject extends ClickableObject {

        protected SummaryObject(WebDriver driver) {

            super(driver);
            elements = driver.findElements(By.cssSelector("#summary-block .radio"));
        }
    }

    final public class ElementsObject extends ClickableObject {

        protected ElementsObject(WebDriver driver) {

            super(driver);
            elements = driver.findElements(By.cssSelector("#elements-block .checkbox"));
        }
    }

    public class SelectableObject extends PageComponent {

        WebElement element;

        protected SelectableObject(WebDriver driver) {

            super(driver);
        }

        public void selectByValue(String value) {

            element.click();

            Select select = new Select(element.findElement(By.cssSelector("select")));
            select.selectByValue(value);
        }
    }

    final public class ColorsObject extends SelectableObject {

        protected ColorsObject(WebDriver driver) {

            super(driver);
            element = driver.findElement(By.cssSelector("#colors"));
        }
    }

    final public class MetalsObject extends SelectableObject {

        protected MetalsObject(WebDriver driver) {

            super(driver);
            element = driver.findElement(By.cssSelector("#metals"));
        }
    }

    final public class VegetablesObject extends SelectableObject {

        protected VegetablesObject(WebDriver driver) {

            super(driver);
            element = driver.findElement(By.cssSelector("#vegetables"));
        }
    }

    final public class SubmitButton extends PageComponent {

        @FindBy(css = "#submit-button")
        WebElement button;
        protected SubmitButton(WebDriver driver) {

            super(driver);
        }

        public void clickButton() {

            button.click();
        }
    }
}
