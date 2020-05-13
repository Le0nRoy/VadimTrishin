package hw_api2.steps;

import hw_api2.assertions.SpellerTextsTestAssertions;
import hw_api2.entities.DTO.YandexSpellerRequestDTO;
import hw_api2.entities.DTO.YandexSpellerResponseDTO;
import hw_api2.entities.testData.SpellerTextTestDataEntity;
import hw_api2.entities.testData.SpellerTextsTestDataEntity;
import hw_api2.service.YandexSpellerService;
import io.restassured.specification.RequestSpecification;

import static hw_api2.utils.Parser.parseTestDataToYandexDTO;

public class SpellerTextsTestSteps {

    private SpellerTextsTestAssertions spellerTextsTestAssertions;
    private SpellerTextsTestDataEntity spellerTextsTestDataEntity;
    private YandexSpellerRequestDTO requestDTO;
    private RequestSpecification requestSpecification;
    private YandexSpellerResponseDTO[] response;

    public SpellerTextsTestSteps() {

        spellerTextsTestAssertions = new SpellerTextsTestAssertions();
    }

    public void setDataAndParseItToRequest(SpellerTextsTestDataEntity data) {

        spellerTextsTestDataEntity = data;
        requestDTO = parseTestDataToYandexDTO(data);
    }

    public void setRequestSpecification(RequestSpecification specification) {

        requestSpecification = specification;
    }

    public void sendRequestAndGetResponse() {

        response = YandexSpellerService.getResponse(requestSpecification,
                requestDTO);
    }

    public void validateNumberOfErrorsInResponse() {

        spellerTextsTestAssertions.validateNumberOfErrorsInResponse(response, spellerTextsTestDataEntity.getNumOfErrorsExpected());
    }
}
