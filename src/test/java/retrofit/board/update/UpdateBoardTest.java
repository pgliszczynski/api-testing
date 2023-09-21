package retrofit.board.update;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit.test.RetrofitClientTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class UpdateBoardTest extends RetrofitClientTest {

    @Test(groups="updateRetro", dependsOnGroups="getterRetro")
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
