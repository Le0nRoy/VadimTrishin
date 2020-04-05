/*
 * 04.04.2020 Vadim Trishin
 *
 * Copyright
 */

package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Class to test division method of Calculator class.
 *
 * @version 1.0 30.03.2020
 * @author Vadim Trishin
 */
public class DivTest extends BaseTestClass {

    @DataProvider
    public static Object[] divTwoNumbersDataProvider() {

        return new Object[][]{
                {50, 20, 2},
                {300, -150, -2},
                {-8, 4, -2},
                {0, -5, 0},
                {5, 1, 5}
        };
    }

    @Test(dataProvider = "divTwoNumbersDataProvider")
    public void divideFirstNumberBySecondWithDataProvider(long num1, long num2, long expected) {

        long result = calculator.div(num1, num2);
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void divideNumberByZeroAndGetException() {

        calculator.div(1, 0);
    }

}
