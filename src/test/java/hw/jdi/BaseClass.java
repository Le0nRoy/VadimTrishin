package hw.jdi;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import hw.jdi.site.EpamSite;
import hw.jdi.site.HomePage;
import hw.jdi.site.MetalsAndColorsPage;
import hw.jdi.site.User;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

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

    @BeforeMethod
    public void beforeTestMethod() {

        initElements(EpamSite.class);
    }
    @AfterMethod
    public void afterTestMethod() {

        killAllSeleniumDrivers();
    }

    @Test(dataProvider = "getFromJsonProvider")
    public void loginOnSiteAndFillFormsTest(MetalsAndColorsTestData testData) {

        EpamSite.open();

        User user = new User("Roman", "Jdi1234", "ROMAN IOVLEV");
        EpamSite.getHomePage().login(user);
        EpamSite.getHomePage().getLoginForm().getUserName().is().text(user.getFullName());

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
    }
}
