package retrofit.board.delete;

import model.creators.RequestCreator;
import model.creators.ResponseCreator;
import model.domain.Board;
import model.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit.client.RetrofitClient;

public class DeleteBoardTest extends BaseTest<Board> {

    @Test(groups="deleteRetro", dependsOnGroups="updateRetro")
    void shouldDeleteBoard() {
        //Given

        //When

        //Then
        validator.checkStatusCode();
    }

    @BeforeMethod
    @Override
    public void sendRequest() {
        actualResponse = httpClient.updateBoard(id);
        createValidator();
    }

    @BeforeClass
    @Override
    public void createHttpClient() {
        httpClient = new RetrofitClient(RequestCreator.getRequestWithId(id));
    }

    @BeforeClass
    @Override
    public void createUserValue() {
        expectedResponse = ResponseCreator.getBoardResponse();
    }
}
