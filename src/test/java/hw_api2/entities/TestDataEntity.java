package hw_api2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TestDataEntity {

    int numOfErrorsExpected;
    int options;
    String text;
    String lang;
    String format;
}
