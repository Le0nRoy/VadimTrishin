package hw.jdi.site;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Url("/metals-colors.html")
public class MetalsAndColorsPage extends WebPage {

    @Css("#odds-selector")
    private WebList oddsSelection;
    @Css("#even-selector")
    private WebList evensSelection;
    @Css("#elements-checklist > .checkbox > label")
    private WebList elementsObject;
    @Css("#colors")
    private Dropdown colors;
    @Css("#metals")
    private Dropdown metals;
    @Css("#vegetables")
    private Dropdown vegetables;
    @Css("#submit-button")
    private Button submitButton;

    @Css(".info-panel-body-result li")
    private WebList results;
    public WebList getResults() {

        return results;
    }

    public MetalsAndColorsPageBuilder builder() {

        return new MetalsAndColorsPageBuilder();
    }

    public class MetalsAndColorsPageBuilder {

        private MetalsAndColorsPageBuilder() {}

        public MetalsAndColorsPageBuilder setSummaryValues(List<Integer> values) {

            if (values == null || values.size() != 2) {
                return this;
            }

            int odd = values.get(0);
            int even = values.get(1);
            if (odd % 2 == 0) {
                even = odd;
                odd = values.get(1);
                if (odd % 2 == 0) {
                    return this;
                }
            }

            oddsSelection.find(By.xpath("//label[contains(text(),'" + odd + "')]")).click();
            evensSelection.find(By.xpath("//label[contains(text(),'" + even + "')]")).click();

            return this;
        }
        public MetalsAndColorsPageBuilder setElementsValues(List<String> values) {

            if (values == null) {
                return this;
            }

            for (String el : values) {
                elementsObject.getUIElement(el).click();
            }

            return this;
        }
        public MetalsAndColorsPageBuilder setColorsValue(String value) {

            if (value == null) {
                return this;
            }

            colors.toggle();
            badSelect(value, colors.finds(By.cssSelector("li")));

            return this;
        }
        public MetalsAndColorsPageBuilder setMetalsValue(String value) {

            if (value == null) {
                return this;
            }

            metals.toggle();
            badSelect(value, metals.finds(By.cssSelector("li")));

            return this;
        }
        public MetalsAndColorsPageBuilder setVegetablesValue(List<String> values) {

            if (values == null) {
                return this;
            }

            vegetables.toggle();
            // Remove default selected value
            badSelect("Vegetables", vegetables.finds(By.cssSelector("li")));
            for (String value : values) {
                badSelect(value, vegetables.finds(By.cssSelector("li")));
            }

            return this;
        }

        public void submit() {

            submitButton.click();
        }

        private void badSelect(String value, WebList selector) {

            for (WebElement el : selector) {
                if (el.getText().equals(value)) {
                    el.click();
                    return;
                }
            }
        }
    }
}
