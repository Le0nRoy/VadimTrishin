package hw_api2;

import hw_api2.entities.DTO.YandexSpellerRequestDTO;
import hw_api2.entities.DTO.YandexSpellerResponseDTO;
import hw_api2.entities.testData.SpellerTextTestDataEntity;
import hw_api2.service.YandexSpellerService;
import org.testng.annotations.Test;

import static hw_api2.utils.Parser.parseTestDataToYandexDTO;
import static org.testng.Assert.assertEquals;

public class SpellerTextTests extends AbstractTest{

    @Test(dataProvider = "spellerTextDataProvider",
            dataProviderClass = DataProviders.class)
    public void makeRequestAndCheckErrorCode(SpellerTextTestDataEntity spellerTextTestDataEntity) {

        YandexSpellerRequestDTO requestDTO = parseTestDataToYandexDTO(spellerTextTestDataEntity);

        YandexSpellerResponseDTO[] response = YandexSpellerService.getResponse(requestSpecification,
                requestDTO);

        if (response.length > 0) {
            assertEquals(response[0].getCode(), spellerTextTestDataEntity.getExpectedCodeOfError(),
                    "Check code of error in response");
        }
    }
}
