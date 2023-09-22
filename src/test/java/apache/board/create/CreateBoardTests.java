package apache.board.create;

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

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class CreateBoardTests extends BaseTest<Board> {

    @Test(groups="creation", dependsOnGroups="authentication")
    void shouldCreateNewBoardTestNG() {
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
        actualResponse = httpClient.postNewBoard();
        id = actualResponse.getBody().getId();
        createValidator();
    }

    @BeforeClass
    @Override
    public void createHttpClient() {
        httpClient = new ApacheClient(RequestCreator
                .getRequestWithName(BoardConfig.getCreatedBoardName()));
    }

    @BeforeClass
    @Override
    public void createUserValue() {
        expectedResponse = ResponseCreator.getBoardResponse();
    }
}
