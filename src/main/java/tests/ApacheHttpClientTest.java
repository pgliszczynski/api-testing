package tests;

import model.Board;
import model.User;
import model.response.ResponseDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import utility.config.BoardConfig;
import utility.config.UserConfig;
import utility.httpclient.ApacheHttpClient;
import utility.validation.ResponseValidator;

public abstract class ApacheHttpClientTest extends BaseTest {
    private static ResponseDto<User> expectedUserResponse;
    private static ResponseDto<Board> expectedBoardResponse;
    protected static ResponseDto<User> actualUserResponse;
    protected static ResponseDto<Board> actualBoardResponse;
    protected static ResponseValidator<User> userResponseValidator;
    protected static ResponseValidator<Board> boardResponseValidator;

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
    public void createExpectedBoardResponse() {
        expectedBoardResponse = new ResponseDto<>(
                200,
                new Board(
                        "0",
                        BoardConfig.getCreatedBoardName()
                )
        );
    }

    @Override
    public void createUserValidator() {
        userResponseValidator = new ResponseValidator<>(expectedUserResponse);
    }

    @Override
    public void createBoardValidator() {
        boardResponseValidator = new ResponseValidator<>(expectedBoardResponse);
    }

    protected void updateExpectedBoardId() {
        expectedBoardResponse.getT().setId(actualBoardResponse.getT().getId());
    }
}
