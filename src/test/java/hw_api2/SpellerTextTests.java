package hw_api2;

import hw_api2.entities.testData.SpellerTextTestDataEntity;
import hw_api2.steps.SpellerTextTestSteps;
import org.testng.annotations.Test;

public class SpellerTextTests extends AbstractTest{

    SpellerTextTestSteps spellerTextTestSteps;

    public SpellerTextTests() {

        spellerTextTestSteps = new SpellerTextTestSteps();
    }

    @Test(dataProvider = "spellerTextDataProvider",
            dataProviderClass = DataProviders.class)
    public void makeRequestAndCheckErrorCode(SpellerTextTestDataEntity spellerTextTestDataEntity) {

        spellerTextTestSteps.setRequestSpecification(requestSpecification);
        spellerTextTestSteps.setDataAndParseItToRequest(spellerTextTestDataEntity);
        spellerTextTestSteps.sendRequestAndGetResponse();
        spellerTextTestSteps.validateResponseCode();
    }
}
