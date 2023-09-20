package tests;

import model.Board;
import model.User;
import model.response.ResponseDto;
import org.testng.annotations.BeforeClass;
import utility.httpclient.ApacheHttpClient;
import utility.response.builder.ResponseBuilder;
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
        expectedUserResponse = ResponseBuilder.getExpectedUserResponse();
    }

    @Override
    public void createExpectedBoardResponse() {
        expectedBoardResponse = ResponseBuilder.getExpectedBoardResponse();
    }

    @Override
    public void createUserValidator() {
        userResponseValidator = new ResponseValidator<>(expectedUserResponse, actualUserResponse);
    }

    @Override
    public void createBoardValidator() {
        boardResponseValidator = new ResponseValidator<>(expectedBoardResponse, actualBoardResponse);
    }

    protected void updateExpectedBoardId() {
        expectedBoardResponse.getT().setId(actualBoardResponse.getT().getId());
    }

    protected String getExpectedBoardId() {
        return expectedBoardResponse.getT().getId();
    }
}
