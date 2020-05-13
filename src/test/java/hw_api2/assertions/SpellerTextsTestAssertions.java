package hw_api2.assertions;

import hw_api2.entities.DTO.YandexSpellerResponseDTO;

import static org.testng.Assert.assertEquals;

public class SpellerTextsTestAssertions {

    public void validateNumberOfErrorsInResponse(YandexSpellerResponseDTO[] response, int numberOfErrorsExpected) {

        assertEquals(response.length, numberOfErrorsExpected,
                "Check number of mistakes in response");
    }
}
