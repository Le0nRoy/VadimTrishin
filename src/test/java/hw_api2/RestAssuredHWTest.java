package hw_api2;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class RestAssuredHWTest {


    private TestDataEntity testDataEntity;

    @BeforeSuite
    public void readProperties() {

        Properties properties = new Properties();
        String propFileName = "hw_api2/test.properties";
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(propFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        testDataEntity = new TestDataEntity(
                properties.getProperty("URL")
        );
    }

    @Test(dataProvider = "jsonDataProvider",
            dataProviderClass = DataProviders.class)
    public void test(JsonObject obj) {

        RestAssured.given().body(obj.toString())
                .when().post(testDataEntity.getUrl())
                .then().statusCode(200);
    }

}
