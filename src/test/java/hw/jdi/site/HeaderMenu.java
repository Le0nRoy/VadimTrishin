package hw.jdi.site;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class HeaderMenu {

    @Css(".navbar-nav")
    public Button navigationMenu;

    @XPath("//*[@role='navigation']//*[contains(text(),'Home')]")
    public Button home;
    @XPath("//*[@role='navigation']//*[contains(text(),'Contact form')]")
    public Button contactForm;
    @XPath("//*[@role='navigation']//*[contains(text(),'Service')]")
    public Button service;
    @XPath("//*[@role='navigation']//*[contains(text(),'Metals & Colors')]")
    public Button metalsAndColors;
}
