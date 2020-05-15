package hw_api2.entities.testData;

import hw_api2.entities.DTO.YandexSpellerRequestDTO;
import lombok.Getter;

@Getter
public class SpellerTextsTestDataEntity extends YandexSpellerRequestDTO {

    int numOfErrorsExpected;

    public SpellerTextsTestDataEntity(int options, String text, String lang, String format, int numOfErrorsExpected) {

        super(options, text, lang, format);
        this.numOfErrorsExpected = numOfErrorsExpected;
    }
}
