package hw_api2;

import hw_api2.entities.DTO.YandexSpellerRequestDTO;
import hw_api2.entities.DTO.YandexSpellerResponseDTO;
import hw_api2.entities.SpellerTextsTestDataEntity;
import hw_api2.service.YandexSpellerService;
import org.testng.annotations.Test;

import static hw_api2.utils.Parser.parseTestDataToYandexDTO;
import static org.testng.Assert.assertEquals;

public class SpellerTextTests extends AbstractTest{

    @Test(dataProvider = "spellerTextDataProvider",
            dataProviderClass = DataProviders.class)
    public void makeRequestAndCheckPresenceOfErrors(SpellerTextsTestDataEntity spellerTextsTestDataEntity) {

        YandexSpellerRequestDTO requestDTO = parseTestDataToYandexDTO(spellerTextsTestDataEntity);

        YandexSpellerResponseDTO[] response = YandexSpellerService.getResponse(requestSpecification,
                requestDTO);

        assertEquals(response.length, spellerTextsTestDataEntity.getNumOfErrorsExpected(),
                "Check number of mistakes in response");
    }
}
