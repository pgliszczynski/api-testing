package model.test;

import model.wrapper.RequestWrapper;
import model.wrapper.ResponseWrapper;
import model.test.validation.ResponseValidator;
import org.testng.annotations.BeforeSuite;
import model.client.HttpClient;

import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    protected static HttpClient httpClient;

    protected RequestWrapper request;
    protected ResponseWrapper<?> expectedResponse;
    protected ResponseWrapper<?> actualResponse;
    protected ResponseValidator<?> validator;

    @BeforeSuite
    public abstract void createHttpClient();

    @BeforeClass
    public abstract void createUserValue();

    @BeforeClass
    public abstract void createValidator();
}
