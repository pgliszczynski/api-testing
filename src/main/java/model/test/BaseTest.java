package model.test;

import io.qameta.allure.Step;
import model.client.HttpClient;
import model.test.validation.ResponseValidator;
import model.wrapper.RequestWrapper;
import model.wrapper.ResponseWrapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest<T> {
    protected static HttpClient httpClient;

    protected RequestWrapper request;
    protected ResponseWrapper<T> expectedResponse;
    protected ResponseWrapper<T> actualResponse;
    protected ResponseValidator<T> validator;

    protected static String id;

    @BeforeMethod
    @Step
    public abstract void sendRequest();

    @BeforeClass
    public abstract void createHttpClient();

    @BeforeClass
    public abstract void createUserValue();

    public void createValidator() {
        validator = new ResponseValidator<>(expectedResponse, actualResponse);
    }
}
