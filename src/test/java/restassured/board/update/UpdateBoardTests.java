package restassured.board.update;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import restassured.test.RestAssuredClientTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class UpdateBoardTests extends RestAssuredClientTests {

    @Test(groups="updateRest", dependsOnGroups="getterRest")
    void shouldUpdateBoard() {
        //Given

        //When

        //Then
        assertTrue(boardResponseValidator.isExpectedResponse());
        assertThat(boardResponseValidator.isExpectedResponse())
                .isTrue();
    }

    @BeforeMethod
    @Override
    public void sendRequest() {
        actualBoardResponse = httpClient.updateBoard(getExpectedBoardId());
        updateExpectedBoardName();
        createBoardValidator();
    }
}
