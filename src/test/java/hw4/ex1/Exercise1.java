package hw4.ex1;

import hw4.BaseTestClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Exercise1 extends BaseTestClass {

    @Test
    @Parameters({"userName", "password"})
    private void exerciseTest(String userName, String password) {

        // Tasks 1 - 2
        openSiteByURLAndCheckItsTitleTest();

        // Tasks 3 - 4
        loginAndCheckUsername(userName, password);

        // Task 7
        navigationHeaderObject.clickHeaderItem("");
    }
}
