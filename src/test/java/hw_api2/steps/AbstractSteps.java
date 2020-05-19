package hw_api2.steps;

import hw_api2.entities.DTO.YandexSpellerRequestDTO;
import hw_api2.entities.DTO.YandexSpellerResponseDTO;
import hw_api2.service.YandexSpellerService;
import io.restassured.specification.RequestSpecification;

public class AbstractSteps {

    protected RequestSpecification requestSpecification;
    protected YandexSpellerResponseDTO[] response;
    protected YandexSpellerRequestDTO requestDTO;

    public void setRequestSpecification(RequestSpecification specification) {

        requestSpecification = specification;
    }

    public void sendRequestAndGetResponse() {

        response = YandexSpellerService.getResponse(requestSpecification,
                requestDTO);
    }

}
