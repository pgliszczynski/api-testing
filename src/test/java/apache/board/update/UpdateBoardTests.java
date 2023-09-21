package apache.board.update;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import apache.test.ApacheClientTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class UpdateBoardTests extends ApacheClientTest {

    @Test(groups="update", dependsOnGroups="getter")
    void shouldUpdateBoardTestNg() {
        //Given

        //When

        //Then
        assertTrue(boardResponseValidator.isExpectedResponse());
    }

    @Test(groups="update", dependsOnGroups="getter")
    void shouldUpdateBoardAssertJ() {
        //Given

        //When

        //Then
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
