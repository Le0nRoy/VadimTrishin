package hw_api2;

import hw_api2.entities.TestProperties;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Properties;

public class AbstractTest {

    protected TestProperties testProperties;

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

}
