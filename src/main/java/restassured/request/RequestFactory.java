package restassured.request;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.wrapper.RequestWrapper;
import utility.url.UrlUtility;

public class RequestFactory {

    public static RequestSpecification buildUserRequest(RequestWrapper requestWrapper) {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(UrlUtility.getUserUrl())
                .addQueryParams(requestWrapper.getQueryParameters())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        return requestSpecification.given().spec(requestSpecification);
    }

    public static RequestSpecification buildBoardRequest(RequestWrapper requestWrapper) {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(UrlUtility.getBoardUrl())
                .addQueryParams(requestWrapper.getQueryParameters())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        return requestSpecification.given().spec(requestSpecification);
    }
}
