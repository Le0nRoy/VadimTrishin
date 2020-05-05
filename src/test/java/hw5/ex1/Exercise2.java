package hw5.ex1;

import hw5.AbstractBaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise2 extends AbstractBaseTest {

    Exercise2Steps steps;

    @BeforeTest
    private void setupSteps() {

        abstractSteps = new Exercise2Steps();
        steps = (Exercise2Steps) abstractSteps;
    }

    @Feature("Test for checking functionality of website")
    @Story("Different Elements page test")
    @Test
    @Parameters({"userName", "password"})
    private void exerciseTest(String userName, String password) {

        String expected;
        List<String> expectedOptionsCheckboxes;
        String expectedOptionRadiobutton;
        String expectedOptionColor;

        // Tasks 1 - 2
        steps.openSiteByURL(TEST_SITE_URL);
        expected = "Home Page";
        steps.siteTitleShouldBe(expected);

        // Tasks 3 - 4
        steps.login(userName, password);
        expected = "ROMAN IOVLEV";
        steps.usernameShouldBe(expected);

        // Task 5
        steps.openDifferentElementsPage();

        // Task 6
        expectedOptionsCheckboxes = new ArrayList<String>(Arrays.asList(
                "Water",
                "Wind"
        ));
        steps.selectCheckboxOptions(expectedOptionsCheckboxes);

        // Task 7
        expectedOptionRadiobutton = "Selen";
        steps.selectRadiobutton(expectedOptionRadiobutton);

        // Task 8
        expectedOptionColor = "Yellow";
        steps.selectColor(expectedOptionColor);

        // Task 9
        steps.checkboxesAreSelected(expectedOptionsCheckboxes);
        steps.radiobuttonIsSelected(expectedOptionRadiobutton);
        steps.colorIsSelected(expectedOptionColor);
    }

}
