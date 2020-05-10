package hw_api2;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class RestAssuredHWTest {

    @Test(dataProvider = "testDataProvider", dataProviderClass = DataProviders.class)
    public void test(Object obj) {

    }

}
