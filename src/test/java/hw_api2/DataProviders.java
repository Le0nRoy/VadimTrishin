package hw_api2;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import hw_api2.entities.testData.SpellerTextTestDataEntity;
import hw_api2.entities.testData.SpellerTextsTestDataEntity;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataProviders {

    private static String spellerTextJsonDataPath;
    private static String spellerTextsJsonDataPath;
    private static String spellerTextJsonDataNamePattern;
    private static String spellerTextsJsonDataNamePattern;

    public static void setSpellerTextJsonDataPath(String spellerTextJsonDataPath) {

        DataProviders.spellerTextJsonDataPath = spellerTextJsonDataPath;
    }

    public static void setSpellerTextsJsonDataPath(String spellerTextsJsonDataPath) {

        DataProviders.spellerTextsJsonDataPath = spellerTextsJsonDataPath;
    }

    public static void setSpellerTextJsonDataNamePattern(String spellerTextJsonDataNamePattern) {

        DataProviders.spellerTextJsonDataNamePattern = spellerTextJsonDataNamePattern;
    }

    public static void setSpellerTextsJsonDataNamePattern(String spellerTextsJsonDataNamePattern) {

        DataProviders.spellerTextsJsonDataNamePattern = spellerTextsJsonDataNamePattern;
    }

    @DataProvider
    public Object[][] spellerTextsDataProvider() {

        JsonElement jsonData = null;
        List<JsonElement> dataSet = new ArrayList<JsonElement>();
        int numOfDataSet = 1;
        Gson gson = new Gson();
        List<SpellerTextsTestDataEntity> testDataEntities = new ArrayList<SpellerTextsTestDataEntity>();
        Object[][] returnValue;

        try {
            jsonData = new JsonParser().parse(new FileReader(spellerTextsJsonDataPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        do {
            dataSet.add(jsonData.getAsJsonObject().get(spellerTextsJsonDataNamePattern + numOfDataSet));
            ++numOfDataSet;
        } while (dataSet.get(numOfDataSet - 2) != null);
        // Subtract 2 because ++ happens first (1)
        // and from begining variable is indented from standard array numerization by one (2)
        dataSet.remove(numOfDataSet - 2);

        for (JsonElement el : dataSet) {
            testDataEntities.add(gson.fromJson(el, SpellerTextsTestDataEntity.class));
        }

        returnValue = new Object[testDataEntities.size()][1];
        for (int i = 0; i < testDataEntities.size(); ++i) {
            returnValue[i][0] = testDataEntities.get(i);
        }
        return returnValue;
    }

    @DataProvider
    public Object[][] spellerTextDataProvider() {

        JsonElement jsonData = null;
        List<JsonElement> dataSet = new ArrayList<JsonElement>();
        int numOfDataSet = 1;
        Gson gson = new Gson();
        List<SpellerTextTestDataEntity> testDataEntities = new ArrayList<SpellerTextTestDataEntity>();
        Object[][] returnValue;

        try {
            jsonData = new JsonParser().parse(new FileReader(spellerTextJsonDataPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        do {
            dataSet.add(jsonData.getAsJsonObject().get(spellerTextJsonDataNamePattern + numOfDataSet));
            ++numOfDataSet;
        } while (dataSet.get(numOfDataSet - 2) != null);
        // Subtract 2 because ++ happens first (1)
        // and from begining variable is indented from standard array numerization by one (2)
        dataSet.remove(numOfDataSet - 2);

        for (JsonElement el : dataSet) {
            testDataEntities.add(gson.fromJson(el, SpellerTextTestDataEntity.class));
        }

        returnValue = new Object[testDataEntities.size()][1];
        for (int i = 0; i < testDataEntities.size(); ++i) {
            returnValue[i][0] = testDataEntities.get(i);
        }
        return returnValue;
    }
}
