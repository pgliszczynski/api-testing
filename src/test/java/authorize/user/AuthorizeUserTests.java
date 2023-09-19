package authorize.user;

import model.User;
import model.response.ResponseDto;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utility.httpclient.ApacheHttpClient;
import utility.httpclient.HttpClient;

public class AuthorizeUserTests {

    @Test
    void shouldAuthorizeAndReturnUser() {
        //Given
        HttpClient httpClient = new ApacheHttpClient();
        SoftAssert softAssert = new SoftAssert();

        //When
        ResponseDto<User> userResponse = httpClient.getUserRequest();

        //Then
        softAssert.assertEquals(userResponse.getStatusCode(), 200);
        softAssert.assertEquals(userResponse.getT().getId(), "65082a8cbb67cb72bede5f5b");
        softAssert.assertEquals(userResponse.getT().getFullName(), "gliszczynskip5");
        softAssert.assertEquals(userResponse.getT().getUsername(), "gliszczynskip5");
        softAssert.assertEquals(userResponse.getT().getEmail(), "gliszczynskip5@gmail.com");
        softAssert.assertAll();
    }
}
