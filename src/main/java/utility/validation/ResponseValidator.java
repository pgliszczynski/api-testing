package utility.validation;

import model.response.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.fail;

public class ResponseValidator<T> {
    private final ResponseDto<T> expectedResponse;
    private final ResponseDto<T> actualResponse;

    private final static Logger LOGGER = LoggerFactory.getLogger("Validator Logger");

    public ResponseValidator(ResponseDto<T> expectedResponse, ResponseDto<T> actualResponse) {
        this.expectedResponse = expectedResponse;
        this.actualResponse = actualResponse;
    }

    private void isValidResponse() {
        LOGGER.info("Validating response");
        if (actualResponse.getStatusCode() < 100
        || actualResponse.getStatusCode() > 600
        || actualResponse.getT() == null) {
            fail("Invalid response");
        }
    }

    public boolean isExpectedResponse() {
        LOGGER.info("Comparing expected and actual response");
        isValidResponse();
        return expectedResponse.equals(actualResponse);
    }
}
