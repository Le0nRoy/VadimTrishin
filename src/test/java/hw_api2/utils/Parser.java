package hw_api2.utils;

import hw_api2.entities.DTO.YandexSpellerRequestDTO;
import hw_api2.entities.TestDataEntity;

public class Parser {

    public static YandexSpellerRequestDTO parseTestDataToYandexDTO(TestDataEntity testData) {

        YandexSpellerRequestDTO requestDTO = new YandexSpellerRequestDTO(
                testData.getOptions(),
                testData.getText(),
                testData.getLang(),
                testData.getFormat()
                );

        return requestDTO;
    }
}
