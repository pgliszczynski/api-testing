package tests;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import utility.httpclient.RestAssuredHttpClient;
import utility.request.RestAssuredRequestBuilder;

public abstract class RestAssuredHttpClientTests extends BaseTest {
    protected static RequestSpecification userRequestSpecification;
    protected static ResponseSpecification userResponseSpecification;

    @BeforeClass
    @Override
    public void createHttpClient() {
        httpClient = new RestAssuredHttpClient();
    }

    @BeforeClass
    public void buildRequest() {
        userRequestSpecification = RestAssuredRequestBuilder.buildGetUserRequest();
    }

    @Override
    public void createExpectedUserResponse() {

    }

    @Override
    public void createExpectedBoardResponse() {

    }

    @Override
    public void createUserValidator() {

    }

    @Override
    public void createBoardValidator() {

    }
}
