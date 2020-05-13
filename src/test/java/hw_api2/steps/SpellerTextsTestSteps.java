package hw_api2.steps;

import hw_api2.assertions.SpellerTextsTestAssertions;
import hw_api2.entities.DTO.YandexSpellerRequestDTO;
import hw_api2.entities.DTO.YandexSpellerResponseDTO;
import hw_api2.entities.testData.SpellerTextTestDataEntity;
import hw_api2.entities.testData.SpellerTextsTestDataEntity;
import hw_api2.service.YandexSpellerService;
import io.restassured.specification.RequestSpecification;

import static hw_api2.utils.Parser.parseTestDataToYandexDTO;

public class SpellerTextsTestSteps extends AbstractSteps {

    private SpellerTextsTestAssertions spellerTextsTestAssertions;
    private SpellerTextsTestDataEntity spellerTextsTestDataEntity;

    public SpellerTextsTestSteps() {

        spellerTextsTestAssertions = new SpellerTextsTestAssertions();
    }

    public void setDataAndParseItToRequest(SpellerTextsTestDataEntity data) {

        spellerTextsTestDataEntity = data;
        requestDTO = parseTestDataToYandexDTO(data);
    }

    public void validateNumberOfErrorsInResponse() {

        spellerTextsTestAssertions.validateNumberOfErrorsInResponse(response, spellerTextsTestDataEntity.getNumOfErrorsExpected());
    }
}
