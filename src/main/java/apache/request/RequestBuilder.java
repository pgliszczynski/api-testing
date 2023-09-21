package apache.request;

import apache.parameters.ParametersMapper;
import model.wrapper.RequestWrapper;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.authorization.AuthorizationUtility;
import model.client.methods.HttpMethod;
import utility.url.UrlUtility;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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
