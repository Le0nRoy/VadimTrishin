package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;

public class BaseTestClass {

    @BeforeTest
    protected void clearPreviousTestData() {

        calculator = new Calculator();
    }

    protected Calculator calculator;

}
