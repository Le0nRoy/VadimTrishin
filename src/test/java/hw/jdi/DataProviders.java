package hw.jdi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Object[][] getFromJsonMetalsAndColorsPageTestDataProvider() {

        JsonElement jsonData = null;
        List<JsonElement> dataSet = new ArrayList<JsonElement>();
        int numOfDataSet = 1;
        List<MetalsAndColorsTestData> testData = new ArrayList<MetalsAndColorsTestData>();
        Gson gson = new Gson();
        Object[][] returnValue = new Object[testData.size()][1];

        try {
            jsonData = new JsonParser().parse(
                    new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json")
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        do {
            dataSet.add(jsonData.getAsJsonObject().get("data_" + numOfDataSet));
            ++numOfDataSet;
        } while (dataSet.get(numOfDataSet - 2) != null);
        // Subtract 2 because ++ happens first (1)
        // and from begining variable is indented from standard array numerization by one (2)
        dataSet.remove(numOfDataSet - 2);

        for (JsonElement el : dataSet) {
            testData.add(gson.fromJson(el, MetalsAndColorsTestData.class));
        }

        for (int i = 0; i < returnValue.length; ++i) {
            returnValue[i][0] = testData.get(i);
        }

        return returnValue;
    }

}
