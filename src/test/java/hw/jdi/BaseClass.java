package hw.jdi;

import hw.jdi.site.EpamSite;
import hw.jdi.site.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

public class BaseClass {

//    private EpamSite epamSite;

    @BeforeMethod(alwaysRun = true)
    public void beforeTestMethod() {

        initElements(EpamSite.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTestMethod() {
        killAllSeleniumDrivers();
    }

    @Test
    public void loginOnSiteAndFillFormsTest() {

        EpamSite.open();
    }
}
