package apache.board.delete;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import apache.test.ApacheClientTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class DeleteBoardTests extends ApacheClientTest {

    @Test(groups="delete", dependsOnGroups="update")
    void shouldDeleteBoardTestNg() {
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
