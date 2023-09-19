package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utility.httpclient.HttpClient;

import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    protected static HttpClient httpClient;

    @BeforeClass
    public abstract void createHttpClient();

    @BeforeSuite
    public void createExpectedValues() {
        createExpectedUserResponse();
        createUserValidator();
    }

    @BeforeMethod
    public abstract void sendRequest();

    public abstract void createExpectedUserResponse();

    public abstract void createUserValidator();
}
