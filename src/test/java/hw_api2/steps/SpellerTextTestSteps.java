package hw_api2.steps;

import hw_api2.assertions.SpellerTextTestAssertions;
import hw_api2.entities.DTO.YandexSpellerRequestDTO;
import hw_api2.entities.DTO.YandexSpellerResponseDTO;
import hw_api2.entities.testData.SpellerTextTestDataEntity;
import hw_api2.service.YandexSpellerService;
import io.restassured.specification.RequestSpecification;

import static hw_api2.utils.Parser.parseTestDataToYandexDTO;

public class SpellerTextTestSteps {

    private SpellerTextTestDataEntity spellerTextTestDataEntity;
    private SpellerTextTestAssertions spellerTextTestAssertions;
    private YandexSpellerRequestDTO requestDTO;
    private RequestSpecification requestSpecification;
    private YandexSpellerResponseDTO[] response;

    public SpellerTextTestSteps() {

        spellerTextTestAssertions = new SpellerTextTestAssertions();
    }

    public void setDataAndParseItToRequest(SpellerTextTestDataEntity data) {

        spellerTextTestDataEntity = data;
        requestDTO = parseTestDataToYandexDTO(data);
    }

    public void setRequestSpecification(RequestSpecification specification) {

        requestSpecification = specification;
    }

        public void sendRequestAndGetResponse() {

            response = YandexSpellerService.getResponse(requestSpecification,
                    requestDTO);
        }

    public void validateResponseCode() {

        spellerTextTestAssertions.validateCodeOfResponse(response, 0, spellerTextTestDataEntity.getExpectedCodeOfError());
    }
}
