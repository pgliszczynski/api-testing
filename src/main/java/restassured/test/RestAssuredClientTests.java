package restassured.test;

import org.testng.annotations.BeforeClass;
import model.test.BaseTest;
import restassured.client.RestAssuredClient;

public abstract class RestAssuredClientTests extends BaseTest {

    @BeforeClass
    @Override
    public void createHttpClient() {
        httpClient = new RestAssuredClient();
    }
}
