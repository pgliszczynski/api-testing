package restassured.board.get;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.RestAssuredHttpClientTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class GetBoardTests extends RestAssuredHttpClientTests {

    @Test(groups="getterRest", dependsOnGroups="creationRest")
    void shouldGetBoardById() {
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
        actualBoardResponse = httpClient.getBoardById(getExpectedBoardId());
        createBoardValidator();
    }
}
