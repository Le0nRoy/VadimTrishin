package hw_api2.utils;

import hw_api2.entities.DTO.YandexSpellerRequestDTO;
import hw_api2.entities.testData.SpellerTextTestDataEntity;
import hw_api2.entities.testData.SpellerTextsTestDataEntity;

public class Parser {

    public static YandexSpellerRequestDTO parseTestDataToYandexDTO(SpellerTextsTestDataEntity testData) {

        YandexSpellerRequestDTO requestDTO = new YandexSpellerRequestDTO(
                testData.getOptions(),
                testData.getText(),
                testData.getLang(),
                testData.getFormat()
                );

        return requestDTO;
    }

    public static YandexSpellerRequestDTO parseTestDataToYandexDTO(SpellerTextTestDataEntity testData) {

        YandexSpellerRequestDTO requestDTO = new YandexSpellerRequestDTO(
                testData.getOptions(),
                testData.getText(),
                testData.getLang(),
                testData.getFormat()
        );

        return requestDTO;
    }
}
