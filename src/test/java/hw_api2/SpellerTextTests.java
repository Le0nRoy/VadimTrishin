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
            dataProviderClass = DataProviders.class,
            enabled = false)
    public void makeRequestAndCheckErrorCode(SpellerTextTestDataEntity dataEntity) {

        spellerTextTestSteps.setRequestSpecification(requestSpecification);
        spellerTextTestSteps.setDataAndParseItToRequest(dataEntity);
        spellerTextTestSteps.sendRequestAndGetResponse();
        spellerTextTestSteps.validateResponseCode();
    }

    @Test(dataProvider = "spellerTextDataProvider",
            dataProviderClass = DataProviders.class,
            enabled = false)
    public void makeRequestndCheckFixedWord(SpellerTextTestDataEntity dataEntity) {

        spellerTextTestSteps.setRequestSpecification(requestSpecification);
        spellerTextTestSteps.setDataAndParseItToRequest(dataEntity);
        spellerTextTestSteps.sendRequestAndGetResponse();
        spellerTextTestSteps.validateFixedWord();
    }

    @Test(dataProvider = "spellerTextDataProvider",
            dataProviderClass = DataProviders.class)
//            enabled = false)
    public void makeRequestWithWrongOptionsAndValidateIt(SpellerTextTestDataEntity dataEntity) {

        spellerTextTestSteps.setRequestSpecification(requestSpecification);
        spellerTextTestSteps.setDataAndParseItToRequest(dataEntity);
        spellerTextTestSteps.setWrongOption();
        spellerTextTestSteps.sendRequestAndGetResponse();
        spellerTextTestSteps.validateResponseCode();
    }

}
