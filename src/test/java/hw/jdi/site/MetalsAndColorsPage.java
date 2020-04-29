package hw.jdi.site;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw.jdi.MetalsAndColorsTestData;
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

    public void setValuesOnPage(MetalsAndColorsTestData data) {

        List<Integer> summary = data.getSummary();
        if (summary != null && summary.size() == 2) {

            int odd = summary.get(0);
            int even = summary.get(1);
            if ((odd % 2 == 0) && (even % 2 != 0)) {
                even = odd;
                odd = summary.get(1);
            }
            oddsSelection.find(By.xpath("//label[contains(text(),'" + odd + "')]")).click();
            evensSelection.find(By.xpath("//label[contains(text(),'" + even + "')]")).click();
        }

        List<String> values = data.getElements();
        if (values != null) {

            for (String el : values) {
                elementsObject.getUIElement(el).click();
            }
        }

        if (data.getColor() != null) {

            colors.toggle();
            badSelect(data.getColor(), colors.finds(By.cssSelector("li")));
        }

        if (data.getMetals() != null) {

            metals.toggle();
            badSelect(data.getMetals(), metals.finds(By.cssSelector("li")));
        }

        values = data.getVegetables();
        if (values != null) {
            vegetables.toggle();
            // Remove default selected value
            badSelect("Vegetables", vegetables.finds(By.cssSelector("li")));
            for (String value : values) {
                badSelect(value, vegetables.finds(By.cssSelector("li")));
            }
        }

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
