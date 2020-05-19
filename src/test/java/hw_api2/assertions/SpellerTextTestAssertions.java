package hw_api2.assertions;

import hw_api2.entities.DTO.YandexSpellerResponseDTO;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SpellerTextTestAssertions {

    public void validateCodeOfResponse(YandexSpellerResponseDTO[] response, int responsePosition, int expectedCode) {

        if (response.length > responsePosition) {
            assertEquals(response[responsePosition].getCode(), expectedCode,
                    "Check code of error in response");
        } else {
            assertEquals(0, expectedCode,
                    "Check code of error in response");
        }
    }

    public void validateFixedWord(YandexSpellerResponseDTO[] response, int responsePosition, String expectedWord) {

        if (response.length > responsePosition) {
            assertTrue(response[responsePosition].getS().contains(expectedWord),
                    "Check fixed word");
        } else {
            assertEquals(null, expectedWord,
                    "Check fixed word");
        }
    }
}
