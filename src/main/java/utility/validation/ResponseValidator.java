package utility.validation;

import model.response.ResponseDto;

public class ResponseValidator<T> {
    private final ResponseDto<T> expectedResponse;

    public ResponseValidator(ResponseDto<T> expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    public boolean isValidResponse(ResponseDto<T> actualResponse) {
        return actualResponse.getStatusCode() >= 100
                && actualResponse.getStatusCode() < 600
                && actualResponse.getT() != null;
    }

    public boolean isExpectedResponse(ResponseDto<T> actualResponse) {
        return expectedResponse.equals(actualResponse);
    }
}
