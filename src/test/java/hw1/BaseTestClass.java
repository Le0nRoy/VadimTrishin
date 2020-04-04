package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;

public class BaseTestClass {

    @BeforeMethod
    protected void clearPreviousTestData() {

        calculator = new Calculator();
    }

    protected Calculator calculator;

}
