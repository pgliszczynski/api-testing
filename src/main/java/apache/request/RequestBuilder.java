package apache.request;

import model.client.methods.HttpMethod;
import model.wrapper.RequestWrapper;
import org.apache.hc.core5.http.ClassicHttpRequest;
import utility.url.UrlUtility;

public class RequestBuilder {
    private final RequestWrapper request;


    public RequestBuilder(RequestWrapper request) {
        this.request = request;
    }

    public ClassicHttpRequest createGetUserRequest() {
        return RequestFactory.createRequest(HttpMethod.GET, request, UrlUtility.getUserUrl());
    }

    public ClassicHttpRequest createPostBoardRequest() {
        return RequestFactory.createRequest(HttpMethod.POST, request, UrlUtility.getBoardUrl());
    }

    public ClassicHttpRequest createGetBoardByIdRequest(String boardId) {
        return RequestFactory.createRequest(HttpMethod.GET, request, UrlUtility.getBoardUrlWithId(boardId));
    }

    public ClassicHttpRequest createUpdateBoardRequest(String boardId) {
        return RequestFactory.createRequest(HttpMethod.PUT, request, UrlUtility.getBoardUrlWithId(boardId));
    }

    public ClassicHttpRequest createDeleteBoardRequest(String boardId) {
        return RequestFactory.createRequest(HttpMethod.DELETE, request, UrlUtility.getBoardUrlWithId(boardId));
    }
}
