package hw.jdi;

import hw.jdi.site.EpamSite;
import hw.jdi.site.User;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static org.testng.Assert.assertEquals;

public class MetalsAndColorsPageTest {

    @BeforeTest
    public void beforeTestMethod() {

        initElements(EpamSite.class);

        EpamSite.open();

        User user = new User("Roman", "Jdi1234", "ROMAN IOVLEV");
        EpamSite.getHomePage().login(user);
        EpamSite.getHomePage().getLoginForm().getUserName().is().text(user.getFullName());

    }
    @AfterTest
    public void afterTestMethod() {

        killAllSeleniumDrivers();
    }

    @Test(dataProvider = "getFromJsonMetalsAndColorsPageTestDataProvider",
            dataProviderClass = DataProviders.class)
    public void loginOnSiteAndFillFormsTest(MetalsAndColorsTestData testData) {

        EpamSite.getHeaderMenu().metalsAndColors.click();
        EpamSite.getMetalsAndColorsPage().checkOpened();

        EpamSite.getMetalsAndColorsPage().setValuesOnPage(testData);

        // Match with pattern
        List<String> resultsPattern = testData.getResultsPattern();
        assertEquals(EpamSite.getMetalsAndColorsPage().getResults().size(), resultsPattern.size());

        SoftAssert softAssert = new SoftAssert();
        List<String> results = new ArrayList<String>();
        for (int i = 0; i < resultsPattern.size(); ++i) {
            String[] str = EpamSite.getMetalsAndColorsPage().getResults().get(i + 1)
                    .getText().split(": ");
            results.add(str[1]);
            softAssert.assertEquals(str[0], resultsPattern.get(i),
                    "Match with pattern, iteration " + i + ":");
        }

        int posSummary = 0;
        int posElements = 1;
        int posColor = 2;
        int posMetal = 3;
        int posVegetables = 4;

        // Check results
        if (testData.getSummary() != null) {
            softAssert.assertEquals(results.get(posSummary),
                    Integer.toString(testData.getSummary().get(0) + testData.getSummary().get(1)),
                    "Check summary: ");
        }

        if (testData.getElements() != null) {
            List<String> elements = testData.getElements();
            String[] elementsResults = results.get(posElements).split(", ");
            softAssert.assertEquals(elementsResults.length, elements.size(),
                    "Check size of elements");
            softAssert.assertEqualsNoOrder(elementsResults, elements.toArray(),
                    "Check elements");
        } else {
            posColor = 1;
            posMetal = 2;
            posVegetables = 3;
        }

        if (testData.getColor() != null) {
            softAssert.assertEquals(results.get(posColor), testData.getColor(),
                    "Check color");
        }
        if (testData.getMetals() != null) {
            softAssert.assertEquals(results.get(posMetal), testData.getMetals(),
                    "Check metals");
        }

        if (testData.getVegetables() != null) {
            List<String> vegetables = testData.getVegetables();
            String[] vegetablesResults = results.get(posVegetables).split(", ");
            softAssert.assertEquals(vegetablesResults.length, vegetables.size(),
                    "Check size of vegetables");
            softAssert.assertEqualsNoOrder(vegetablesResults, vegetables.toArray(),
                    "Check vegetables");
        }

        softAssert.assertAll();
    }

}
