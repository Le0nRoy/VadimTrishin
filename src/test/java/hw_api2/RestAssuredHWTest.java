package hw_api2;

import com.google.gson.JsonObject;
import org.testng.annotations.Test;

public class RestAssuredHWTest {

//    @Test(dataProvider = "propertiesDataProvider", dataProviderClass = DataProviders.class)
    @Test(dataProvider = "jsonDataProvider",
            dataProviderClass = DataProviders.class)
    public void test(JsonObject obj) {

        System.out.println(obj);
    }

}
