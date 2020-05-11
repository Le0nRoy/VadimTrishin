package hw_api2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SpellerTextsTestDataEntity {

    int numOfErrorsExpected;
    int options;
    String text;
    String lang;
    String format;
}