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
 * Class to test subtraction method of Calculator class.
 *
 * @version 1.0 30.03.2020
 * @author Vadim Trishin
 */
public class SubTest extends BaseTestClass {

    @DataProvider
    public static Object[] subTwoNumbersDataProvider() {

        return new Object[][]{
                {50, 20, 30},
                {300, -150, 450},
                {-8, 4, -12},
                {0, 0, 0},
                {5, 0, 5},
                {0, 5, -5},
        };
    }

    @Test(dataProvider = "subTwoNumbersDataProvider")
    public void subTwoNumbersWithDataProvider(long num1, long num2, long expected) {

        long result = calculator.sub(num1, num2);
        Assert.assertEquals(result, expected);
    }

}
