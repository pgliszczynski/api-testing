package apache.authorize.user;

import apache.client.ApacheClient;
import model.creators.RequestCreator;
import model.creators.ResponseCreator;
import model.domain.User;
import model.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertTrue;

public class AuthorizeUserTests extends BaseTest<User> {

    @Test(groups="authentication")
    void shouldAuthorizeAndReturnUserTestNG() {
        //Given

        //When

        //Then
        assertTrue(validator.isExpectedResponse());
        assertThat(validator.isExpectedResponse())
                .isTrue();
    }

    @BeforeMethod
    @Override
    public void sendRequest() {
        actualResponse = httpClient.getUserRequest();
        createValidator();
    }

    @BeforeSuite
    @Override
    public void createHttpClient() {
        httpClient = new ApacheClient(RequestCreator.getBasicRequest());
    }

    @BeforeClass
    @Override
    public void createUserValue() {
        expectedResponse = ResponseCreator.getUserResponse();
    }
}
