package model.test;

import model.domain.Board;
import model.domain.User;
import model.wrapper.ResponseWrapper;
import model.test.validation.ResponseValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utility.config.BoardConfig;
import model.client.HttpClient;

import org.testng.annotations.BeforeClass;
import apache.response.ResponseBuilder;

public abstract class BaseTest {
    protected static HttpClient httpClient;

    protected static ResponseWrapper<User> expectedUserResponse;
    protected static ResponseWrapper<Board> expectedBoardResponse;
    protected static ResponseWrapper<User> actualUserResponse;
    protected static ResponseWrapper<Board> actualBoardResponse;
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
        expectedBoardResponse.getBody().setId(actualBoardResponse.getBody().getId());
    }

    protected void updateExpectedBoardName() {
        expectedBoardResponse.getBody().setName(BoardConfig.getUpdatedBoardName());
    }

    protected String getExpectedBoardId() {
        return expectedBoardResponse.getBody().getId();
    }
}
