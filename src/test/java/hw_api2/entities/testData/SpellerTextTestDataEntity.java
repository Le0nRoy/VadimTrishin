package hw_api2.entities.testData;

import hw_api2.entities.DTO.YandexSpellerRequestDTO;
import lombok.Getter;

@Getter
public class SpellerTextTestDataEntity extends YandexSpellerRequestDTO {

    int expectedCodeOfError;

    public SpellerTextTestDataEntity(int options, String text, String lang, String format, int expectedCodeOfError) {
        super(options, text, lang, format);
        this.expectedCodeOfError = expectedCodeOfError;
    }
}
