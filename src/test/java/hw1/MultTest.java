package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultTest {

    @DataProvider
    public static Object[] multTwoNumbersDataProvider() {

        return new Object[][]{
                {50, 20, 1000},
                {300, -150, -45000},
                {-8, 4, -32},
                {0, 0, 0},
                {5, 0, 0},
                {0, -5, 0},
        };
    }

    @Test(dataProvider = "multTwoNumbersDataProvider")
    public void multTwoNumbersWithDataProvider(long num1, long num2, long expected) {

        long result = calculator.mult(num1, num2);
        Assert.assertEquals(result, expected);
    }

    @BeforeTest
    private void clearPreviousTestData() {

        calculator = new Calculator();
    }

    private Calculator calculator;

}
