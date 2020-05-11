package hw_api2;

import hw_api2.entities.DTO.YandexSpellerRequestDTO;
import hw_api2.entities.TestDataEntity;
import hw_api2.entities.DTO.YandexSpellerResponseDTO;
import hw_api2.service.YandexSpellerService;
import org.testng.annotations.Test;

import static hw_api2.utils.Parser.parseTestDataToYandexDTO;
import static org.testng.Assert.assertEquals;

public class SpellerTextsTests extends AbstractTest {

    @Test(dataProvider = "rightRequestDataProvider",
            dataProviderClass = DataProviders.class)
    public void makeRequestAndCheckNumberOfMistakes(TestDataEntity testData) {

        YandexSpellerRequestDTO requestDTO = parseTestDataToYandexDTO(testData);

        YandexSpellerResponseDTO[] response = YandexSpellerService.getResponse(requestSpecification,
                requestDTO);

        assertEquals(response.length, testData.getNumOfErrorsExpected(),
                "Check number of mistakes in response");
    }

}
