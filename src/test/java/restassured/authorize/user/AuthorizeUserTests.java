package restassured.authorize.user;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import model.User;
import model.response.ResponseDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.RestAssuredHttpClientTests;
import utility.config.UserConfig;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AuthorizeUserTests extends RestAssuredHttpClientTests {
    private final ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Test
    void shouldAuthorizeUser() {
        RequestSpecification request = given().spec(userRequestSpecification);
        Response response = request.when().get();
        response.then().spec(responseSpecification).body(
                "id", equalTo(UserConfig.getId()),
                "fullName", equalTo(UserConfig.getFullName()),
                "username", equalTo(UserConfig.getUsername()),
                "email", equalTo(UserConfig.getEmail())
        );

        ResponseDto<User> actualResponse = new ResponseDto<>(
                response.statusCode(),
                response.as(User.class)
        );

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResponse.getStatusCode(), 200);
        softAssert.assertEquals(actualResponse.getT().getId(), UserConfig.getId());
        softAssert.assertEquals(actualResponse.getT().getFullName(), UserConfig.getFullName());
        softAssert.assertEquals(actualResponse.getT().getUsername(), UserConfig.getUsername());
        softAssert.assertEquals(actualResponse.getT().getEmail(), UserConfig.getEmail());
    }

    @BeforeMethod
    @Override
    public void sendRequest() {

    }
}
