package tests;

import org.testng.annotations.BeforeClass;
import utility.httpclient.RetrofitClient;

public abstract class RetrofitHttpClientTest extends BaseTest {

    @BeforeClass
    @Override
    public void createHttpClient() {
        httpClient = new RetrofitClient();
    }
}
