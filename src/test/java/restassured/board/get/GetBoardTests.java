package restassured.board.get;

import model.creators.RequestCreator;
import model.creators.ResponseCreator;
import model.domain.Board;
import model.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import restassured.client.RestAssuredClient;
import utility.config.BoardConfig;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class GetBoardTests extends BaseTest<Board> {

    @Test(groups="getterRest", dependsOnGroups="creationRest")
    void shouldGetBoardById() {
        //Given

        //When

        //Then
        assertTrue(validator.isExpectedResponse());
        assertThat(validator.isExpectedResponse())
                .isTrue();
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
        httpClient = new RestAssuredClient(RequestCreator.getRequestWithId(id));
    }

    @BeforeClass
    @Override
    public void createUserValue() {
        expectedResponse = ResponseCreator.getBoardResponse();
    }
}
