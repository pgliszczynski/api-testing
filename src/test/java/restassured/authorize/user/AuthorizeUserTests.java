package restassured.authorize.user;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.RestAssuredHttpClientTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class AuthorizeUserTests extends RestAssuredHttpClientTests {

    @Test(groups="authenticationRest", dependsOnGroups="delete")
    void shouldAuthorizeUser() {
        //Given

        //When

        //Then
        assertTrue(userResponseValidator.isExpectedResponse());
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
