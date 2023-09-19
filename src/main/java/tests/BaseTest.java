package tests;

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

    public abstract void createExpectedUserResponse();

    public abstract void createUserValidator();
}
