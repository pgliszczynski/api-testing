package apache.authorize.user;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.ApacheHttpClientTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertTrue;

public class AuthorizeUserTests extends ApacheHttpClientTest {

    @Test(groups="authentication")
    void shouldAuthorizeAndReturnUserTestNG() {
        //Given

        //When

        //Then
        assertTrue(userResponseValidator.isExpectedResponse());
    }

    @Test(groups="authentication")
    void shouldAuthorizeAndReturnUserAssertJ() {
        //Given

        //When

        //Then
        assertThat(userResponseValidator.isExpectedResponse())
                .isTrue();
    }

    @BeforeMethod
    @Override
    public void sendRequest() {
        actualUserResponse = httpClient.getUserRequest();
        createUserValidator();
    }
}
