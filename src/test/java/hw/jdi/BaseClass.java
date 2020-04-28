package hw.jdi;

import com.epam.jdi.light.elements.complex.WebList;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import hw.jdi.site.EpamSite;
import hw.jdi.site.MetalsAndColorsPage;
import hw.jdi.site.User;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static org.testng.Assert.assertEquals;

public class BaseClass {

    private int numOfDataSets = 5;

    @DataProvider
    public Object[][] getFromJsonProvider() {

        JsonElement jsonData = null;
        try {
            jsonData = new JsonParser().parse(
                    new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json")
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<JsonElement> dataSet = new ArrayList<JsonElement>(numOfDataSets);
        for (int i = 1; i <= numOfDataSets; ++i) {

            dataSet.add(jsonData.getAsJsonObject().get("data_" + i));
        }

        List<MetalsAndColorsTestData> testData = new ArrayList<MetalsAndColorsTestData>();
        Gson gson = new Gson();
        for (JsonElement el : dataSet) {

            testData.add(gson.fromJson(el, MetalsAndColorsTestData.class));
        }

        Object[][] returnValue = new Object[testData.size()][1];
        for (int i = 0; i < returnValue.length; ++i) {
            returnValue[i][0] = testData.get(i);
        }

        return returnValue;
    }

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

    @Test(dataProvider = "getFromJsonProvider")
    public void loginOnSiteAndFillFormsTest(MetalsAndColorsTestData testData) {

        EpamSite.getHeaderMenu().metalsAndColors.click();
        MetalsAndColorsPage metalsAndColorsPage = EpamSite.getMetalsAndColorsPage();
        metalsAndColorsPage.checkOpened();

        metalsAndColorsPage.builder()
                .setSummaryValues(testData.getSummary())
                .setElementsValues(testData.getElements())
                .setColorsValue(testData.getColor())
                .setMetalsValue(testData.getMetals())
                .setVegetablesValue(testData.getVegetables())
                .submit();

        List<String> resultsPattern = new ArrayList<String>();
        resultsPattern.add("Summary: ");
        if (testData.getElements() != null) {
            resultsPattern.add("Elements: ");
        }
        resultsPattern.add("Color: ");
        resultsPattern.add("Metal: ");
        resultsPattern.add("Vegetables: ");

        SoftAssert softAssert = new SoftAssert();
        WebList results = metalsAndColorsPage.getResults();
        assertEquals(results.size(), resultsPattern.size());
        for (int i = 0; i < resultsPattern.size(); ++i) {
            softAssert.assertTrue(results.get(i+1).getText().contains(resultsPattern.get(i)));
        }

        int posSummary = 1;
        int posElements = 2;
        int posColor = 3;
        int posMetal = 4;
        int posVegetables = 5;

        // Check results
        if (testData.getSummary() != null) {
            softAssert.assertTrue(results.get(posSummary).getText()
                    .contains(Integer.toString(testData.getSummary().get(0) + testData.getSummary().get(1))));
        }

        if (testData.getElements() != null) {
            List<String> elements = testData.getElements();
            String elementsResult = results.get(posElements).getText();
            softAssert.assertEquals(elementsResult.split(", ").length, elements.size());
            for (String str : elements) {
                softAssert.assertTrue(elementsResult.contains(str));
            }
        } else {
            posColor = 2;
            posMetal = 3;
            posVegetables = 4;
        }

        if (testData.getColor() != null) {
            softAssert.assertTrue(results.get(posColor).getText().contains(testData.getColor()));
        }
        if (testData.getMetals() != null) {
            softAssert.assertTrue(results.get(posMetal).getText().contains(testData.getMetals()));
        }

        if (testData.getVegetables() != null) {
            List<String> vegetables = testData.getVegetables();
            String vegetablesResult = results.get(posVegetables).getText();
            softAssert.assertEquals(vegetablesResult.split(", ").length, vegetables.size());
            for (String str : vegetables) {
                softAssert.assertTrue(vegetablesResult.contains(str));
            }
        }

        softAssert.assertAll();
    }
}
