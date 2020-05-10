package hw_api2;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class DataProviders {

    @DataProvider
    public Object[][] propertiesDataProvider() {

        Properties properties = new Properties();
        String propFileName = "hw_api2/test.properties";
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(propFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String text = properties.getProperty("text");
        String lang = properties.getProperty("lang");
        String options = properties.getProperty("options");
        String format = properties.getProperty("format");
        // FIXME уточнить, нужен именно .properties файл или же можно создать json со всеми тестовыми данными?
        //  если именно .properties, то он должен быть один со всеми тестовыми данными? или куча?
        TestDataEntity testDataEntity = new TestDataEntity(text, lang, options, format);

        String jsonString = new Gson().toJson(testDataEntity);

        return new Object[1][1];
    }

    @DataProvider
    public Object[][] jsonDataProvider() {

        JsonElement jsonData = null;
        List<JsonElement> dataSet = new ArrayList<JsonElement>();
        int numOfDataSet = 1;
//        List<TestDataEntity> testData = new ArrayList<TestDataEntity>();
        Gson gson = new Gson();
        Object[][] returnValue = new Object[1][1];

        try {
            jsonData = new JsonParser().parse(
                    new FileReader("src/test/resources/hw_api2/test.json")
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

        returnValue[0] = dataSet.toArray();

        return returnValue;
    }
}
