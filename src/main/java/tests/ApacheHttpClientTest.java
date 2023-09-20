package tests;

import org.testng.annotations.BeforeClass;
import utility.config.BoardConfig;
import utility.httpclient.ApacheHttpClient;

public abstract class ApacheHttpClientTest extends BaseTest {

    @BeforeClass
    @Override
    public void createHttpClient() {
        httpClient = new ApacheHttpClient();
    }

    protected String getExpectedBoardId() {
        return expectedBoardResponse.getT().getId();
    }
}
