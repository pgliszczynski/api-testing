package retrofit.authorize.user;

import model.User;
import model.response.ResponseDto;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import utility.authorization.AuthorizationUtility;
import utility.config.UserConfig;
import utility.httpclient.service.TrelloService;
import utility.url.UrlUtility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthorizeUserTests {

    @Test
    void shouldAuthorizeUser() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlUtility.getBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        TrelloService trelloService = retrofit.create(TrelloService.class);

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("key", AuthorizationUtility.getApiKey());
        queryParams.put("token", AuthorizationUtility.getTrelloToken());

        Call<User> user = trelloService.authorizeUser(queryParams);
        ResponseDto<User> userResponseDto = new ResponseDto<>(
                0,
                new User()
        );
        try {
            Response<User> userResponse = user.execute();
            userResponseDto = new ResponseDto<>(
                    userResponse.code(),
                    userResponse.body()
            );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userResponseDto.getStatusCode(), 200);
        softAssert.assertEquals(userResponseDto.getT().getId(), UserConfig.getId());
        softAssert.assertEquals(userResponseDto.getT().getFullName(), UserConfig.getFullName());
        softAssert.assertEquals(userResponseDto.getT().getUsername(), UserConfig.getUsername());
        softAssert.assertEquals(userResponseDto.getT().getEmail(), UserConfig.getEmail());
        softAssert.assertAll();
    }
}
