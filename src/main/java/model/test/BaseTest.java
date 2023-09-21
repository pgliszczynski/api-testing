package model.test;

import model.domain.User;
import model.wrapper.RequestWrapper;
import model.wrapper.ResponseWrapper;
import model.test.validation.ResponseValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import model.client.HttpClient;

import org.testng.annotations.BeforeClass;

public abstract class BaseTest<T> {
    protected static HttpClient httpClient;

    protected RequestWrapper request;
    protected ResponseWrapper<T> expectedResponse;
    protected ResponseWrapper<T> actualResponse;
    protected ResponseValidator<T> validator;

    protected static String id;

    @BeforeMethod
    public abstract void sendRequest();

    @BeforeSuite
    public abstract void createHttpClient();

    @BeforeClass
    public abstract void createUserValue();

    public void createValidator() {
        validator = new ResponseValidator<>(expectedResponse, actualResponse);
    }
}
