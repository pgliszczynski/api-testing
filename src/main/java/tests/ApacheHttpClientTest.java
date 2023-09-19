package tests;

import model.Board;
import model.User;
import model.response.ResponseDto;
import org.testng.annotations.BeforeClass;
import utility.config.UserConfig;
import utility.httpclient.ApacheHttpClient;
import utility.validation.ResponseValidator;

public abstract class ApacheHttpClientTest extends BaseTest {
    private static ResponseDto<User> expectedUserResponse;
    private static ResponseDto<Board> expectedBoardResponse;
    private static ResponseValidator<User> userResponseValidator;

    @BeforeClass
    @Override
    public void createHttpClient() {
        httpClient = new ApacheHttpClient();
    }

    @Override
    public void createExpectedUserResponse() {
        expectedUserResponse = new ResponseDto<>(
                200,
                new User(
                        UserConfig.getId(),
                        UserConfig.getFullName(),
                        UserConfig.getUsername(),
                        UserConfig.getEmail()
                )
        );
    }

    @Override
    public void createUserValidator() {
        userResponseValidator = new ResponseValidator<>(expectedUserResponse);
    }
}
