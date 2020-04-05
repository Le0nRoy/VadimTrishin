/*
 * 04.04.2020 Vadim Trishin
 *
 * Copyright
 */

package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;

/**
 * Class to clean state of tested class for test methods.
 *
 * @version 1.0 30.03.2020
 * @author Vadim Trishin
 */
public class BaseTestClass {

    protected Calculator calculator;

    @BeforeMethod
    protected void clearPreviousTestData() {

        calculator = new Calculator();
    }

}
