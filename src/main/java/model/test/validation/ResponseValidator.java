package model.test.validation;

import model.wrapper.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.fail;

public class ResponseValidator<T> {
    private final ResponseWrapper<T> expectedResponse;
    private final ResponseWrapper<T> actualResponse;

    private final static Logger LOGGER = LoggerFactory.getLogger("Validator Logger");

    public ResponseValidator(ResponseWrapper<T> expectedResponse, ResponseWrapper<T> actualResponse) {
        this.expectedResponse = expectedResponse;
        this.actualResponse = actualResponse;
    }

    private void isValidResponse() {
        LOGGER.info("Validating response");
        if (actualResponse.getStatusCode() < 100
        || actualResponse.getStatusCode() > 600
        || actualResponse.getBody() == null) {
            fail("Invalid response");
        }
    }

    public boolean isExpectedResponse() {
        LOGGER.info("Comparing expected and actual response");
        isValidResponse();
        LOGGER.info("Actual Response: " + actualResponse.toString());
        LOGGER.info("Expected Response: " + expectedResponse.toString());
        return expectedResponse.equals(actualResponse);
    }

    public boolean isExpectedResponseWithNoBody() {
        LOGGER.info("Checking response with no body (only response status code");
        return actualResponse.getStatusCode() == 200;
    }
}
