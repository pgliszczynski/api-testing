package apache.board.delete;

import apache.client.ApacheClient;
import model.creators.RequestCreator;
import model.creators.ResponseCreator;
import model.domain.Board;
import model.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class DeleteBoardTests extends BaseTest<Board> {

    @Test(groups="delete", dependsOnGroups="update")
    void shouldDeleteBoardTestNg() {
        //Given

        //When

        //Then
        assertTrue(validator.isExpectedResponseWithNoBody());
        assertThat(validator.isExpectedResponseWithNoBody())
                .isTrue();
    }

    @BeforeMethod
    @Override
    public void sendRequest() {
        actualResponse = httpClient.deleteBoard(id);
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
