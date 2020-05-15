package hw_api2.entities.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class YandexSpellerRequestDTO {

    protected int options;
    protected String text;
    protected String lang;
    protected String format;
}
