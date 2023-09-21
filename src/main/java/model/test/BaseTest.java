package model.test;

import model.domain.Board;
import model.domain.User;
import model.wrapper.RequestWrapper;
import model.wrapper.ResponseWrapper;
import model.test.validation.ResponseValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utility.config.BoardConfig;
import model.client.HttpClient;

import org.testng.annotations.BeforeClass;
import model.creators.ResponseCreator;

public abstract class BaseTest<T> {
    protected static HttpClient httpClient;

    protected RequestWrapper request;
    protected ResponseWrapper<T> expectedResponse;
    protected ResponseWrapper<T> actualResponse;

    protected static ResponseWrapper<User> expectedUserResponse;
    protected static ResponseWrapper<Board> expectedBoardResponse;
    protected static ResponseWrapper<User> actualUserResponse;
    protected static ResponseWrapper<Board> actualBoardResponse;
    protected static ResponseValidator<User> userResponseValidator;
    protected static ResponseValidator<Board> boardResponseValidator;

    @BeforeSuite
    public abstract void createHttpClient();

    @BeforeClass
    public void createExpectedValues() {
        createExpectedUserResponse();
        createExpectedBoardResponse();
    }

    @BeforeMethod
    public abstract void sendRequest();

    public void createExpectedUserResponse() {
        expectedUserResponse = ResponseCreator.getUserResponse();
    }

    public void createExpectedBoardResponse() {
        expectedBoardResponse = ResponseCreator.getBoardResponse();
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
