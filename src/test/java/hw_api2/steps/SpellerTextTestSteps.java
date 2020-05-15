package hw_api2.steps;

import hw_api2.assertions.SpellerTextTestAssertions;
import hw_api2.entities.testData.SpellerTextTestDataEntity;

import static hw_api2.utils.Parser.parseTestDataToYandexDTO;

public class SpellerTextTestSteps extends AbstractSteps {

    private SpellerTextTestDataEntity spellerTextTestDataEntity;
    private SpellerTextTestAssertions spellerTextTestAssertions;

    public SpellerTextTestSteps() {

        spellerTextTestAssertions = new SpellerTextTestAssertions();
    }

    public void setDataAndParseItToRequest(SpellerTextTestDataEntity data) {

        spellerTextTestDataEntity = data;
        requestDTO = parseTestDataToYandexDTO(data);
    }

    public void validateResponseCode() {

        spellerTextTestAssertions.validateCodeOfResponse(response, 0, spellerTextTestDataEntity.getExpectedCodeOfError());
    }

}
