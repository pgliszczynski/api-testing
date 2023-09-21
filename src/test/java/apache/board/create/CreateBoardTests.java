package apache.board.create;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import apache.test.ApacheClientTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class CreateBoardTests extends ApacheClientTest {

    @Test(groups="creation", dependsOnGroups="authentication")
    void shouldCreateNewBoardTestNG() {
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
