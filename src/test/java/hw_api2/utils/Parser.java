package hw_api2.utils;

import hw_api2.entities.DTO.YandexSpellerRequestDTO;
import hw_api2.entities.SpellerTextsTestDataEntity;

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
}
