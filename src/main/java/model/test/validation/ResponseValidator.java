package model.test.validation;

import model.wrapper.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ResponseValidator<T> {
    private final ResponseWrapper<T> expectedResponse;
    private final ResponseWrapper<T> actualResponse;

    private final static Logger LOGGER = LoggerFactory.getLogger("Validator Logger");

    public ResponseValidator(ResponseWrapper<T> expectedResponse, ResponseWrapper<T> actualResponse) {
        this.expectedResponse = expectedResponse;
        this.actualResponse = actualResponse;
    }

    public void checkStatusCode() {
        LOGGER.info("Validating status code");
        LOGGER.info("Actual status code: " + actualResponse.getStatusCode());
        LOGGER.info("Expected status code: " + expectedResponse.getStatusCode());

        assertEquals(actualResponse.getStatusCode(), expectedResponse.getStatusCode());
        assertThat(actualResponse.getStatusCode())
                .isEqualTo(expectedResponse.getStatusCode());
    }

    public void checkHasBody() {
        LOGGER.info("Validating response body existence");

        assertNotNull(actualResponse.getBody());
        assertThat(actualResponse.getBody())
                .isNotNull();
    }

    public void checkId(String actualId, String expectedId) {
        LOGGER.info("Validating returned ID");

        assertEquals(actualId, expectedId);
        assertThat(actualId).isEqualTo(expectedId);
    }

    public void checkResponse() {
        LOGGER.info("Validating response");
        LOGGER.info("Actual response: " + actualResponse.getBody());

        assertEquals(actualResponse.getBody(), expectedResponse.getBody());
        assertThat(actualResponse.getBody())
                .isEqualTo(expectedResponse.getBody());
    }
}
