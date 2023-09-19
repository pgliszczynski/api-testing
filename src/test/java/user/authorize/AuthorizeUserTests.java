package user.authorize;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.ApacheHttpClientTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertTrue;

public class AuthorizeUserTests extends ApacheHttpClientTest {

    @Test
    void shouldAuthorizeAndReturnUserTestNG() {
        //Given

        //When

        //Then
        assertTrue(userResponseValidator.isExpectedResponse(actualUserResponse));
    }

    @Test
    void shouldAuthorizeAndReturnUserAssertJ() {
        //Given

        //When

        //Then
        assertThat(userResponseValidator.isExpectedResponse(actualUserResponse))
                .isTrue();
    }

    @BeforeMethod
    @Override
    public void sendRequest() {
        actualUserResponse = httpClient.getUserRequest();
    }
}
