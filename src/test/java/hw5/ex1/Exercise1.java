package hw5.ex1;

import hw5.AbstractBaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise1 extends AbstractBaseTest {

    Exercise1Steps steps;

    @BeforeTest
    private void setupSteps() {

        abstractSteps = new Exercise1Steps();
        steps = (Exercise1Steps) abstractSteps;
    }

    @Test
    @Parameters({"userName", "password"})
    private void exerciseTest(String userName, String password) {

        String expected;
        List<String> expectedNames;
        int expectedNumOfElements;
        int expectedNumOfImages;
        int expectedNumOfTextsUnderImages;

        // Tasks 1 - 2
        steps.openSiteByURL(TEST_SITE_URL);
        expected = "Home Page";
        steps.siteTitleShouldBe(expected);

        // Tasks 3 - 4
        steps.login(userName, password);
        expected = "ROMAN IOVLEV";
        steps.usernameShouldBe(expected);

        // Task 5
        steps.getHeaderItems();
        expectedNumOfElements = 4;
        steps.numberOfElementsGotInPreviousStepShouldBe(expectedNumOfElements);
        expectedNames = new ArrayList<String>(Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors"
        ));
        steps.elementsGotInPreviousStepShouldBe(expectedNames);

        // Task 6
        steps.getBenefitIcons();
        expectedNumOfImages = 4;
        steps.numberOfElementsGotInPreviousStepShouldBe(expectedNumOfImages);

        // Task 7
        steps.getBenefitTexts();
        expectedNumOfTextsUnderImages = 4;
        steps.numberOfElementsGotInPreviousStepShouldBe(expectedNumOfTextsUnderImages);

        // Task 8
        steps.getFrameButton();
        expected = "https://jdi-testing.github.io/jdi-light/frame-button.html";
        steps.elementGotInPreviousStepAttributeValueShouldBe(expected, "src");

        // Task 9
        steps.getFrameButtonFromFrame();
        expected = "Frame Button";
        steps.elementGotInPreviousStepAttributeValueShouldBe(expected, "value");

        // Task 10
        steps.openSiteByURL(TEST_SITE_URL);

        // Task 11
        steps.getLeftMenuItems();
        expectedNumOfElements = 5;
        steps.numberOfElementsGotInPreviousStepShouldBe(expectedNumOfElements);
        expectedNames = new ArrayList<String>(Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors",
                "Elements packs"
        ));
        steps.elementsGotInPreviousStepShouldBe(expectedNames);
    }
}
