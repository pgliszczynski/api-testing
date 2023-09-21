package apache.test;

import org.testng.annotations.BeforeClass;
import model.test.BaseTest;
import apache.client.ApacheClient;

public abstract class ApacheClientTest extends BaseTest {

    @BeforeClass
    @Override
    public void createHttpClient() {
        httpClient = new ApacheClient();
    }
}
