package hw_api2.entities.testData;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SpellerTextTestDataEntity {

    int expectedCodeOfError;
    int options;
    String text;
    String lang;
    String format;
}
