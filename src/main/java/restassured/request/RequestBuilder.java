package restassured.request;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utility.authorization.AuthorizationUtility;
import utility.url.UrlUtility;

public class RequestBuilder {

    public static RequestSpecification buildUserRequest() {
        return new RequestSpecBuilder()
                .setBaseUri(UrlUtility.getUserUrl())
                .addQueryParam("key", AuthorizationUtility.getApiKey())
                .addQueryParam("token", AuthorizationUtility.getTrelloToken())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification buildBoardWithNameRequest(String name) {
        return new RequestSpecBuilder()
                .setBaseUri(UrlUtility.getBoardUrl())
                .addQueryParam("name", name)
                .addQueryParam("key", AuthorizationUtility.getApiKey())
                .addQueryParam("token", AuthorizationUtility.getTrelloToken())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification buildBoardRequest() {
        return new RequestSpecBuilder()
                .setBaseUri(UrlUtility.getBoardUrl())
                .addQueryParam("key", AuthorizationUtility.getApiKey())
                .addQueryParam("token", AuthorizationUtility.getTrelloToken())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}
