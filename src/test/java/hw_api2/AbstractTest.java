package hw_api2;

import hw_api2.entities.TestProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Properties;

public class AbstractTest {

    protected TestProperties testProperties;
    protected RequestSpecification requestSpecification;

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
                properties.getProperty("URL"),
                properties.getProperty("testDataPath"),
                properties.getProperty("jsonDataNamePattern")
        );

        DataProviders.setTestDataPath(testProperties.getTestDataPath());
        DataProviders.setJsonDataNamePattern(testProperties.getJsonDataNamePattern());

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(testProperties.getUrl())
//                .addFilter(new RequestLoggingFilter())
//                .addFilter(new ResponseLoggingFilter())
                .build();
    }

}
