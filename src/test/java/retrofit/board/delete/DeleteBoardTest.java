package retrofit.board.delete;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit.test.RetrofitClientTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class DeleteBoardTest extends RetrofitClientTest {

    @Test(groups="deleteRetro", dependsOnGroups="updateRetro")
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
