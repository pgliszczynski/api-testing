package utility.request;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utility.authorization.AuthorizationUtility;
import utility.config.BoardConfig;
import utility.url.UrlUtility;

public class RestAssuredRequestBuilder {

    public static RequestSpecification buildGetUserRequest() {
        return new RequestSpecBuilder()
                .setBaseUri(UrlUtility.getUserUrl())
                .addQueryParam("key", AuthorizationUtility.getApiKey())
                .addQueryParam("token", AuthorizationUtility.getTrelloToken())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification buildGetBoardWithNameRequest(String name) {
        return new RequestSpecBuilder()
                .setBaseUri(UrlUtility.geBoardUrl())
                .addQueryParam("name", name)
                .addQueryParam("key", AuthorizationUtility.getApiKey())
                .addQueryParam("token", AuthorizationUtility.getTrelloToken())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification buildGetBoardRequest() {
        return new RequestSpecBuilder()
                .setBaseUri(UrlUtility.geBoardUrl())
                .addQueryParam("key", AuthorizationUtility.getApiKey())
                .addQueryParam("token", AuthorizationUtility.getTrelloToken())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}
