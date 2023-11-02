package restassured.board.delete;

import io.qameta.allure.Step;
import model.creators.RequestCreator;
import model.creators.ResponseCreator;
import model.domain.Board;
import model.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import restassured.client.RestAssuredClient;

public class DeleteBoardTests extends BaseTest<Board> {

    @Test(groups="deleteRest", dependsOnGroups="updateRest")
    void shouldDeleteBoard() {
        //Given

        //When

        //Then
        validator.checkStatusCode();
    }

    @Step
    @BeforeMethod
    @Override
    public void sendRequest() {
        actualResponse = httpClient.deleteBoard(id);
        createValidator();
    }

    @BeforeClass
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
