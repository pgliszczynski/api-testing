package restassured.board.delete;

import model.creators.RequestCreator;
import model.creators.ResponseCreator;
import model.domain.Board;
import model.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import restassured.client.RestAssuredClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class DeleteBoardTests extends BaseTest<Board> {

    @Test(groups="deleteRest", dependsOnGroups="updateRest")
    void shouldDeleteBoard() {
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
        httpClient = new RestAssuredClient(RequestCreator
                .getRequestWithId(id));
    }

    @BeforeClass
    @Override
    public void createUserValue() {
        expectedResponse = ResponseCreator.getBoardResponse();
    }
}
