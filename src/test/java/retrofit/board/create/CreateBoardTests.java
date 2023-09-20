package retrofit.board.create;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.RetrofitHttpClientTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class CreateBoardTests extends RetrofitHttpClientTest {

    @Test(groups="createRetro", dependsOnGroups="authorizeRetro")
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
