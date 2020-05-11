package hw_api2.entities;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TestDataEntity {

    int numOfErrorsExpected;
    String expectedMistakes;
    @Expose
    int options;
    @Expose
    String text;
    @Expose
    String lang;
    @Expose
    String format;
}
