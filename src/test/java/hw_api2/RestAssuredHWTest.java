package hw_api2;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class RestAssuredHWTest {


    private TestProperties testProperties;

    @BeforeSuite
    public void readProperties() {

        Properties properties = new Properties();
        String propFileName = "hw_api2/test.properties";
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(propFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        testProperties = new TestProperties(
                properties.getProperty("URL")
        );
    }

    @Test(dataProvider = "jsonDataProvider",
            dataProviderClass = DataProviders.class)
    public void test(TestDataEntity obj) {

        String body = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(obj);
        System.out.println(obj.getNumOfErrorsExpected());
        System.out.println(body);
        RestAssured.given().body(body)
                .when().post(testProperties.getUrl())
                .then().statusCode(200);
    }

}
