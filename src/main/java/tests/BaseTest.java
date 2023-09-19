package tests;

import model.Board;
import model.User;
import model.response.ResponseDto;
import org.testng.annotations.BeforeSuite;
import utility.httpclient.HttpClient;

import org.testng.annotations.BeforeClass;
import utility.response.builder.ResponseBuilder;

public abstract class BaseTest {
    protected static HttpClient httpClient;
    protected static ResponseDto<User> expectedUserResponse;
    protected static ResponseDto<Board> expectedBoardResponse;

    @BeforeClass
    public abstract void createHttpClient();

    @BeforeSuite
    public void createExpectedUserResponse() {
        expectedUserResponse = ResponseBuilder.getExpectedUserResponse();
    }
}
