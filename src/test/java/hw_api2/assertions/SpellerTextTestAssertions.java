package hw_api2.assertions;

import hw_api2.entities.DTO.YandexSpellerResponseDTO;

import static org.testng.Assert.assertEquals;

public class SpellerTextTestAssertions {

    public void validateCodeOfResponse(YandexSpellerResponseDTO[] response, int responsePosition, int expectedCode) {

        if (response.length > responsePosition + 1) {
            assertEquals(response[responsePosition].getCode(), expectedCode,
                    "Check code of error in response");
        }
    }
}
