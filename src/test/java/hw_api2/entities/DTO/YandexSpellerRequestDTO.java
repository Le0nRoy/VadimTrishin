package hw_api2.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class YandexSpellerRequestDTO {

    int options;
    String text;
    String lang;
    String format;
}
