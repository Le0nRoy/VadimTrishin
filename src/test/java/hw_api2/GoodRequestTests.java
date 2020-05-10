package hw_api2;

import com.google.gson.GsonBuilder;
import hw_api2.entities.TestDataEntity;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class GoodRequestTests extends AbstractTest {

    @Test(dataProvider = "rightRequestDataProvider",
            dataProviderClass = DataProviders.class)
    public void test(TestDataEntity obj) {

        String body = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(obj);
        RequestSpecification requestSpecification = given()
                .body(body)
                .baseUri(testProperties.getUrl());

        given(requestSpecification)
                .then().statusCode(200)
                .and().body("word", hasItems("test", "data"));

        // TODO add json validation
        // TODO Add check of errors number

    }

}
