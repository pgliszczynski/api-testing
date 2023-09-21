package retrofit.test;

import org.testng.annotations.BeforeClass;
import model.test.BaseTest;
import retrofit.client.RetrofitClient;

public abstract class RetrofitClientTest extends BaseTest {

    @BeforeClass
    @Override
    public void createHttpClient() {
        httpClient = new RetrofitClient();
    }
}
