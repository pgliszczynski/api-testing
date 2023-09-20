package utility.response.validator;

import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class RestAssuredResponseValidator {

    public static void verifyResponse(Response actualResponse,
                                          ResponseSpecification responseSpecification) {
        actualResponse.then().spec(responseSpecification);
    }
}
