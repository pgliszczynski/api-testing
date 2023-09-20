package tests;

import model.Board;
import model.User;
import model.response.ResponseDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utility.config.BoardConfig;
import utility.httpclient.HttpClient;

import org.testng.annotations.BeforeClass;
import utility.response.builder.ResponseBuilder;
import utility.validation.ResponseValidator;

public abstract class BaseTest {
    protected static HttpClient httpClient;

    protected static ResponseDto<User> expectedUserResponse;
    protected static ResponseDto<Board> expectedBoardResponse;
    protected static ResponseDto<User> actualUserResponse;
    protected static ResponseDto<Board> actualBoardResponse;
    protected static ResponseValidator<User> userResponseValidator;
    protected static ResponseValidator<Board> boardResponseValidator;

    @BeforeClass
    public abstract void createHttpClient();

    @BeforeSuite
    public void createExpectedValues() {
        createExpectedUserResponse();
        createExpectedBoardResponse();
    }

    @BeforeMethod
    public abstract void sendRequest();

    public void createExpectedUserResponse() {
        expectedUserResponse = ResponseBuilder.getExpectedUserResponse();
    }

    public void createExpectedBoardResponse() {
        expectedBoardResponse = ResponseBuilder.getExpectedBoardResponse();
    }

    public void createUserValidator() {
        userResponseValidator = new ResponseValidator<>(expectedUserResponse, actualUserResponse);
    }

    public void createBoardValidator() {
        boardResponseValidator = new ResponseValidator<>(expectedBoardResponse, actualBoardResponse);
    }

    protected void updateExpectedBoardId() {
        expectedBoardResponse.getT().setId(actualBoardResponse.getT().getId());
    }

    protected void updateExpectedBoardName() {
        expectedBoardResponse.getT().setName(BoardConfig.getUpdatedBoardName());
    }

    protected String getExpectedBoardId() {
        return expectedBoardResponse.getT().getId();
    }
}
