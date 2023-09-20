package tests;

import org.testng.annotations.BeforeClass;
import utility.httpclient.RestAssuredHttpClient;

public abstract class RestAssuredHttpClientTests extends BaseTest {

    @BeforeClass
    @Override
    public void createHttpClient() {
        httpClient = new RestAssuredHttpClient();
    }
}
