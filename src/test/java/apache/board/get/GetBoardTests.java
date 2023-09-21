package apache.board.get;

import apache.client.ApacheClient;
import model.creators.RequestCreator;
import model.creators.ResponseCreator;
import model.domain.Board;
import model.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GetBoardTests extends BaseTest<Board> {

    @Test(groups="getter", dependsOnGroups="creation")
    void shouldGetABoardTestNg() {
        //Given

        //When

        //Then
        assertTrue(validator.isExpectedResponse());
    }


    @BeforeMethod
    @Override
    public void sendRequest() {
        actualResponse = httpClient.getBoardById(id);
        createValidator();
    }

    @BeforeSuite
    @Override
    public void createHttpClient() {
        httpClient = new ApacheClient(RequestCreator.getRequestWithId(id));
    }

    @BeforeClass
    @Override
    public void createUserValue() {
        expectedResponse = ResponseCreator.getBoardResponse();
    }
}
