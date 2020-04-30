package hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AbstractBaseTest implements Constants {

    protected AbstractSteps steps;

    @BeforeTest
    protected void beforeTestMethod() {

        WebDriverManager.chromedriver().setup();
    }

    @AfterTest
    protected void closeChrome() {

        steps.closeDriver();
    }

}
