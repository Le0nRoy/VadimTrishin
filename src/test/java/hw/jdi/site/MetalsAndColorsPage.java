package hw.jdi.site;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

@Url("/metals-colors.html")
public class MetalsAndColorsPage extends WebPage {

    @Css("#colors")
    private Dropdown colors;
    @Css("#metals")
    private Dropdown metals;
    @Css("#vegetables")
    private Dropdown vegetables;
}
