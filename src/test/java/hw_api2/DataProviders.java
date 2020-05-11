package hw_api2;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import hw_api2.entities.TestDataEntity;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataProviders {

    private static String testDataPath;
    private static String jsonDataNamePattern;

    public static void setTestDataPath(String str) {

        DataProviders.testDataPath = str;
    }

    public static void setJsonDataNamePattern(String str) {

        DataProviders.jsonDataNamePattern = str;
    }

    @DataProvider
    public Object[][] rightRequestDataProvider() {

        JsonElement jsonData = null;
        List<JsonElement> dataSet = new ArrayList<JsonElement>();
        int numOfDataSet = 1;
        Gson gson = new Gson();
        List<TestDataEntity> testDataEntities = new ArrayList<TestDataEntity>();
        Object[][] returnValue;

        try {
            jsonData = new JsonParser().parse(new FileReader(testDataPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        do {
            dataSet.add(jsonData.getAsJsonObject().get(jsonDataNamePattern + numOfDataSet));
            ++numOfDataSet;
        } while (dataSet.get(numOfDataSet - 2) != null);
        // Subtract 2 because ++ happens first (1)
        // and from begining variable is indented from standard array numerization by one (2)
        dataSet.remove(numOfDataSet - 2);

        for (JsonElement el : dataSet) {
            testDataEntities.add(gson.fromJson(el, TestDataEntity.class));
        }

        returnValue = new Object[testDataEntities.size()][1];
        for (int i = 0; i < testDataEntities.size(); ++i) {
            returnValue[i][0] = testDataEntities.get(i);
        }
        return returnValue;
    }
}
