package hw_api2;

import com.google.gson.GsonBuilder;
import hw_api2.entities.TestDataEntity;
import hw_api2.entities.YandexSpellerDTO;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class RequestTests extends AbstractTest {

    @Test(dataProvider = "rightRequestDataProvider",
            dataProviderClass = DataProviders.class)
    public void test(TestDataEntity testData) {

        RequestSpecification specification = given(requestSpecification);

        specification.param("text", testData.getText());
        specification.param("lang", testData.getLang());
        specification.param("format", testData.getFormat());
        specification.param("options", testData.getOptions());

        YandexSpellerDTO[] response = specification
                .get()
                .then()
                .statusCode(200)
                .extract()
                .as(YandexSpellerDTO[].class);

        assertEquals(response.length, testData.getNumOfErrorsExpected());
    }
}
