package utility.request;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import utility.authorization.AuthorizationUtility;
import utility.url.UrlUtility;

public class RestAssuredRequestBuilder {

    public static RequestSpecification buildGetUserRequest() {
        return new RequestSpecBuilder()
                .setBaseUri(UrlUtility.getUserUrl())
                .addQueryParam("key", AuthorizationUtility.getApiKey())
                .addQueryParam("token", AuthorizationUtility.getTrelloToken())
                .log(LogDetail.ALL)
                .build();
    }
}
