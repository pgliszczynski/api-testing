package restassured.request;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSender {

    public Response sendGetRequest(RequestSpecification requestSpecification) {
        return requestSpecification.when().get();
    }

    public Response sendPostRequest(RequestSpecification requestSpecification) {
        return requestSpecification.when().post();
    }

    public Response sendGetByIdRequest(String boardId, RequestSpecification requestSpecification) {
        return requestSpecification.when().get("/" + boardId);
    }

    public Response sendPutRequest(String boardId, RequestSpecification requestSpecification) {
        return requestSpecification.when().put("/" + boardId);
    }

    public Response sendDeleteRequest(String boardId, RequestSpecification requestSpecification) {
        return requestSpecification.when().delete("/" + boardId);
    }
}
