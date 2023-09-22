package apache.board.update;

import apache.client.ApacheClient;
import model.creators.RequestCreator;
import model.creators.ResponseCreator;
import model.domain.Board;
import model.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utility.config.BoardConfig;

import static org.testng.Assert.assertTrue;

public class UpdateBoardTests extends BaseTest<Board> {

    @Test(groups="update", dependsOnGroups="getter")
    void shouldUpdateBoardTestNg() {
        //Given

        //When

        //Then
        validator.checkStatusCode();
        validator.checkHasBody();
        validator.checkResponse();
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
        httpClient = new ApacheClient(RequestCreator
                .getRequestWithIdAndName(id, BoardConfig.getUpdatedBoardName()));
    }

    @BeforeClass
    @Override
    public void createUserValue() {
        expectedResponse = ResponseCreator.getUpdatedBoardResponse();
    }
}
