package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import utility.httpclient.RestAssuredHttpClient;

public abstract class RestAssuredHttpClientTests extends BaseTest {

    @BeforeClass
    @Override
    public void createHttpClient() {
        httpClient = new RestAssuredHttpClient();
    }

    @BeforeClass
    public void cleanExpectedValuesAfterPreviousTests() {
        createExpectedValues();
    }
}
