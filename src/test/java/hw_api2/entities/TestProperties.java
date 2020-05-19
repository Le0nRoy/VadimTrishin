package hw_api2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestProperties {

    private String url;
    private String spellerTextJsonDataPath;
    private String spellerTextsJsonDataPath;
    private String spellerTextJsonDataNamePattern;
    private String spellerTextsJsonDataNamePattern;
}

