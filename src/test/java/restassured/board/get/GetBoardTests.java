package restassured.board.get;

import model.creators.RequestCreator;
import model.creators.ResponseCreator;
import model.domain.Board;
import model.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import restassured.client.RestAssuredClient;

public class GetBoardTests extends BaseTest<Board> {

    @Test(groups="getterRest", dependsOnGroups="creationRest")
    void shouldGetBoardById() {
        //Given

        //When

        //Then
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
        httpClient = new RestAssuredClient(RequestCreator.getRequestWithId(id));
    }

    @BeforeClass
    @Override
    public void createUserValue() {
        expectedResponse = ResponseCreator.getBoardResponse();
    }
}
