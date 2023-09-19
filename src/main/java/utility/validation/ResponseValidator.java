package utility.validation;

import model.response.ResponseDto;

import static org.testng.Assert.fail;

public class ResponseValidator<T> {
    private final ResponseDto<T> expectedResponse;

    public ResponseValidator(ResponseDto<T> expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    public void isValidResponse(ResponseDto<T> actualResponse) {
        if (actualResponse.getStatusCode() < 100
        || actualResponse.getStatusCode() > 600
        || actualResponse.getT() == null) {
            fail("Invalid response");
        }
    }

    public boolean isExpectedResponse(ResponseDto<T> actualResponse) {
        isValidResponse(actualResponse);
        return expectedResponse.equals(actualResponse);
    }
}
