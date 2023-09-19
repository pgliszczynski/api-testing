package utility.validation;

import model.response.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.fail;

public class ResponseValidator<T> {
    private final ResponseDto<T> expectedResponse;

    private final static Logger LOGGER = LoggerFactory.getLogger("Validator Logger");

    public ResponseValidator(ResponseDto<T> expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    private void isValidResponse(ResponseDto<T> actualResponse) {
        LOGGER.info("Validating response");
        if (actualResponse.getStatusCode() < 100
        || actualResponse.getStatusCode() > 600
        || actualResponse.getT() == null) {
            fail("Invalid response");
        }
    }

    public boolean isExpectedResponse(ResponseDto<T> actualResponse) {
        LOGGER.info("Comparing expected and actual response");
        isValidResponse(actualResponse);
        return expectedResponse.equals(actualResponse);
    }
}
