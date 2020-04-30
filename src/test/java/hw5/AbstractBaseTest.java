package hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class AbstractBaseTest implements Constants {

    protected AbstractSteps abstractSteps;

    @BeforeTest
    protected void beforeTestMethod() {

        WebDriverManager.chromedriver().setup();
    }

    @AfterTest
    protected void closeChrome() {

        abstractSteps.closeDriver();
    }

}
