package restassured.authorize.user;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import model.User;
import model.response.ResponseDto;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utility.authorization.AuthorizationUtility;
import utility.config.UserConfig;
import utility.url.UrlUtility;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AuthorizeUserTests {
    private final RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(UrlUtility.getUserUrl())
            .addQueryParam("key", AuthorizationUtility.getApiKey())
            .addQueryParam("token", AuthorizationUtility.getTrelloToken())
            .log(LogDetail.ALL)
            .build();
    private final ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Test
    void shouldAuthorizeUser() {
        RequestSpecification request = given().spec(requestSpecification);
        Response response = request.get();
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
}
