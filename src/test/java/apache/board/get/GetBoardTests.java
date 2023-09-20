package apache.board.get;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.ApacheHttpClientTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class GetBoardTests extends ApacheHttpClientTest {

    @Test(groups="getter", dependsOnGroups="creation")
    void shouldGetABoardTestNg() {
        //Given

        //When

        //Then
        assertTrue(boardResponseValidator.isExpectedResponse());
    }

    @Test(groups="getter", dependsOnGroups="creation")
    void shouldGetABoardAssertJ() {
        //Given

        //When

        //Then
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
