package hw_api2;

import hw_api2.entities.testData.SpellerTextsTestDataEntity;
import hw_api2.steps.SpellerTextsTestSteps;
import org.testng.annotations.Test;

public class SpellerTextsTests extends AbstractTest {

    SpellerTextsTestSteps spellerTextsTestSteps;

    public SpellerTextsTests() {

        spellerTextsTestSteps = new SpellerTextsTestSteps();
    }

    @Test(dataProvider = "spellerTextsDataProvider",
            dataProviderClass = DataProviders.class,
            enabled = false)
    public void makeRequestAndCheckNumberOfMistakes(SpellerTextsTestDataEntity testData) {

        spellerTextsTestSteps.setRequestSpecification(requestSpecification);
        spellerTextsTestSteps.setDataAndParseItToRequest(testData);
        spellerTextsTestSteps.sendRequestAndGetResponse();
        spellerTextsTestSteps.validateNumberOfErrorsInResponse();
    }

}
