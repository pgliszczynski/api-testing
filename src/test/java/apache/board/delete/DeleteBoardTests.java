package apache.board.delete;

import apache.client.ApacheClient;
import model.creators.RequestCreator;
import model.creators.ResponseCreator;
import model.domain.Board;
import model.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoardTests extends BaseTest<Board> {

    @Test(groups="delete", dependsOnGroups="update")
    void shouldDeleteBoardTestNg() {
        //Given

        //When

        //Then
        validator.checkStatusCode();
    }

    @BeforeMethod
    @Override
    public void sendRequest() {
        actualResponse = httpClient.deleteBoard(id);
        createValidator();
    }

    @BeforeClass
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
