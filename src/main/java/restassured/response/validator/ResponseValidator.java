package restassured.response.validator;

import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class ResponseValidator {

    public static void verifyResponse(Response actualResponse,
                                          ResponseSpecification responseSpecification) {
        actualResponse.then().spec(responseSpecification);
    }
}
