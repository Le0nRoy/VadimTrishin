package hw_api2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestProperties {

    private String url;
    private String testDataPath;
    private String jsonDataNamePattern;
}

