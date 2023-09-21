package restassured.authorize.user;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import restassured.test.RestAssuredClientTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class AuthorizeUserTests extends RestAssuredClientTests {

    @Test(groups="authenticationRest", dependsOnGroups="delete")
    void shouldAuthorizeUser() {
        //Given
        createExpectedValues();

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
