package hw_api2.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YandexSpellerResponseDTO {

    private int code;
    private int pos;
    private int row;
    private int col;
    private int len;
    private String word;
    private List<String> s;
}
