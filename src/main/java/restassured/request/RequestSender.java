package restassured.request;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSender {
    private final RequestSpecification requestSpecification;

    public RequestSender(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public Response sendGetRequest() {
        return requestSpecification.when().get();
    }

    public Response sendPostRequest() {
        return requestSpecification.when().post();
    }

    public Response sendGetByIdRequest(String boardId) {
        return requestSpecification.when().get("/" + boardId);
    }

    public Response sendPutRequest(String boardId) {
        return requestSpecification.when().put("/" + boardId);
    }

    public Response sendDeleteRequest(String boardId) {
        return requestSpecification.when().delete("/" + boardId);
    }
}
