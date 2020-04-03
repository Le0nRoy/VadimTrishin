package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SumTest {

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

    @BeforeTest
    private void clearPreviousTestData() {

        calculator = new Calculator();
    }

    private Calculator calculator;

}
