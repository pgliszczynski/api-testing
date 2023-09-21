package restassured.response;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import utility.config.UserConfig;

import static org.hamcrest.Matchers.equalTo;

public class ResponseBuilder {

    public ResponseSpecification buildUserResponse() {
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

    public ResponseSpecification buildBoardResponse(String name) {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("name", equalTo(name))
                .log(LogDetail.ALL)
                .build();
    }

    public ResponseSpecification buildBoardResponseWithId(String boardId, String name) {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("id", equalTo(boardId))
                .expectBody("name", equalTo(name))
                .log(LogDetail.ALL)
                .build();
    }

    public ResponseSpecification buildEmptyResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}
