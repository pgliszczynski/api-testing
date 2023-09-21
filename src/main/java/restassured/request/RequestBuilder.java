package restassured.request;

import io.restassured.specification.RequestSpecification;
import model.wrapper.RequestWrapper;
public class RequestBuilder {
    private final RequestWrapper request;

    public RequestBuilder(RequestWrapper request) {
        this.request = request;
    }

    public RequestSpecification createUserRequest() {
        return RequestFactory.buildUserRequest(request);
    }

    public RequestSpecification createBoardRequest() {
        return RequestFactory.buildBoardRequest(request);
    }
}
