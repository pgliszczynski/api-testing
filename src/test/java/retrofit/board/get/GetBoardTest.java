package retrofit.board.get;

import model.creators.RequestCreator;
import model.creators.ResponseCreator;
import model.domain.Board;
import model.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit.client.RetrofitClient;
import utility.config.BoardConfig;

public class GetBoardTest extends BaseTest<Board> {

    @Test(groups="getterRetro", dependsOnGroups="createRetro")
    void shouldGetBoard() {
        //Given

        //Then

        //When
        validator.checkStatusCode();
        validator.checkHasBody();
        validator.checkId(actualResponse.getBody().getId(), id);
        validator.checkResponse();
    }

    @BeforeMethod
    @Override
    public void sendRequest() {
        actualResponse = httpClient.getBoardById(id);
        createValidator();
    }

    @BeforeClass
    @Override
    public void createHttpClient() {
        httpClient = new RetrofitClient(RequestCreator.getRequestWithIdAndName(
                id,
                BoardConfig.getCreatedBoardName()));
    }

    @BeforeClass
    @Override
    public void createUserValue() {
        expectedResponse = ResponseCreator.getBoardResponse();
    }
}
