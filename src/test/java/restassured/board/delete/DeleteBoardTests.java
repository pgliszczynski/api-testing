package restassured.board.delete;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import restassured.test.RestAssuredClientTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class DeleteBoardTests extends RestAssuredClientTests {

    @Test(groups="deleteRest", dependsOnGroups="updateRest")
    void shouldDeleteBoard() {
        //Given

        //When

        //Then
        assertTrue(boardResponseValidator.isExpectedResponseWithNoBody());
        assertThat(boardResponseValidator.isExpectedResponseWithNoBody())
                .isTrue();
    }

    @BeforeMethod
    @Override
    public void sendRequest() {
        actualBoardResponse = httpClient.deleteBoard(getExpectedBoardId());
        createBoardValidator();
    }
}
