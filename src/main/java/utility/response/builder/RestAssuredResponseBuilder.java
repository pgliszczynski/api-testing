package utility.response.builder;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import utility.config.UserConfig;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredResponseBuilder {

    public static ResponseSpecification buildUserResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("id", equalTo(UserConfig.getId()))
                .expectBody("fullName", equalTo(UserConfig.getFullName()))
                .expectBody("username", equalTo(UserConfig.getUsername()))
                .expectBody("email", equalTo(UserConfig.getEmail()))
                .log(LogDetail.ALL)
                .build();
    }
}
