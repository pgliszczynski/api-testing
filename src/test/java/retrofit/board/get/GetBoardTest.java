package retrofit.board.get;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit.test.RetrofitClientTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class GetBoardTest extends RetrofitClientTest {

    @Test(groups="getterRetro", dependsOnGroups="createRetro")
    void shouldGetBoard() {
        //Given

        //Then

        //When
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
