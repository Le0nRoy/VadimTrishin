package hw_api2.service;

import hw_api2.entities.DTO.YandexSpellerRequestDTO;
import hw_api2.entities.DTO.YandexSpellerResponseDTO;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class YandexSpellerService {

    public static YandexSpellerResponseDTO[] getResponse(final RequestSpecification specification,
                                                  YandexSpellerRequestDTO requestDTO) {

        RequestSpecification requestSpecification = given(specification);

        requestSpecification.param("text", requestDTO.getText());
        requestSpecification.param("lang", requestDTO.getLang());
        requestSpecification.param("format", requestDTO.getFormat());
        requestSpecification.param("options", requestDTO.getOptions());

        YandexSpellerResponseDTO[] response = requestSpecification
                .get()
                .then()
                .extract()
                .as(YandexSpellerResponseDTO[].class);

        return response;
    }
}
