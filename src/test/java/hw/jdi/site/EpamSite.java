package hw.jdi.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class EpamSite {

    @Url("/index.html")
    private static HomePage homePage;
    private static HeaderMenu headerMenu;
    private static MetalsAndColorsPage metalsAndColorsPage;

    public static void open() {

        homePage.open();
    }

    public static HomePage getHomePage() {

        return homePage;
    }

    public static HeaderMenu getHeaderMenu() {

        return headerMenu;
    }

    public static MetalsAndColorsPage getMetalsAndColorsPage() {

        return metalsAndColorsPage;
    }

}
