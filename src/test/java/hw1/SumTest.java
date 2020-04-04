/*
 * 04.04.2020 Vadim Trishin
 *
 * Copyright
 */

package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Class to test summary method of Calculator class.
 *
 * @version 1.0 30.03.2020
 * @author Vadim Trishin
 */
public class SumTest extends BaseTestClass {

    @DataProvider
    public static Object[] sumTwoNumbersDataProvider() {

        return new Object[][]{
                {50, 20, 70},
                {300, -150, 150},
                {-8, 4, -4},
                {0, 0, 0},
                {5, 0, 5},
        };
    }

    @Test(dataProvider = "sumTwoNumbersDataProvider")
    @Parameters({"num1", "num2"})
    public void sumTwoNumbersWithDataProvider(long num1, long num2, long expected) {

        long result = calculator.sum(num1, num2);
        Assert.assertEquals(result, expected);
    }

}
