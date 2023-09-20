package restassured.board.create;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.RestAssuredHttpClientTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class CreateBoardTests extends RestAssuredHttpClientTests {

    @Test(groups="creationRest", dependsOnGroups="authenticationRest")
    void shouldCreateNewBoard() {
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
        actualBoardResponse = httpClient.postNewBoard();
        updateExpectedBoardId();
        createBoardValidator();
    }
}
