package board.create;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.ApacheHttpClientTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class CreateBoardTests extends ApacheHttpClientTest {

    @Test(groups="creation", dependsOnGroups="authentication")
    void shouldCreateNewBoardTestNG() {
        //Given

        //When

        //Then
        assertTrue(boardResponseValidator.isExpectedResponse());
    }

    @Test(groups="creation", dependsOnGroups="authentication")
    void shouldCreateNewBoardAssertJ() {
        //Given

        //When

        //Then
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
