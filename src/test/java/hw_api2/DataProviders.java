package hw_api2;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
    public Object[][] jsonDataProvider() {

        String propFileName = "src/test/resources/hw_api2/test.json";
        JsonElement jsonData = null;
        List<JsonElement> dataSet = new ArrayList<JsonElement>();
        int numOfDataSet = 1;
        Object[][] returnValue;

        try {
            jsonData = new JsonParser().parse(
                    new FileReader(propFileName)
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

        returnValue = new Object[dataSet.size()][1];
        for (int i = 0; i < dataSet.size(); ++i) {
            returnValue[i][0] = dataSet.get(i);
        }
        return returnValue;
    }
}
