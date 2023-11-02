package restassured.board.update;

import io.qameta.allure.Step;
import model.creators.RequestCreator;
import model.creators.ResponseCreator;
import model.domain.Board;
import model.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import restassured.client.RestAssuredClient;
import utility.config.BoardConfig;

public class UpdateBoardTests extends BaseTest<Board> {

    @Test(groups="updateRest", dependsOnGroups="getterRest")
    void shouldUpdateBoard() {
        //Given

        //When

        //Then
        validator.checkStatusCode();
        validator.checkHasBody();
        validator.checkId(actualResponse.getBody().getId(), id);
        validator.checkResponse();
    }

    @Step
    @BeforeMethod
    @Override
    public void sendRequest() {
        actualResponse = httpClient.updateBoard(id);
        createValidator();
    }

    @BeforeClass
    @Override
    public void createHttpClient() {
        httpClient = new RestAssuredClient(RequestCreator
                .getRequestWithIdAndName(id, BoardConfig.getUpdatedBoardName()));
    }

    @BeforeClass
    @Override
    public void createUserValue() {
        expectedResponse = ResponseCreator.getUpdatedBoardResponse();
    }
}
