package apache.request;

import apache.request.uri.UriBuilder;
import model.client.methods.HttpMethod;
import model.wrapper.RequestWrapper;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.core5.http.ClassicHttpRequest;

public class RequestFactory {
    public static ClassicHttpRequest createRequest(HttpMethod httpMethod, RequestWrapper requestWrapper, String url) {
        ClassicHttpRequest httpRequest;

        switch(httpMethod) {
            case GET:
                httpRequest = new HttpGet(url);
                break;
            case POST:
                httpRequest = new HttpPost(url);
                break;
            case PUT:
                httpRequest = new HttpPut(url);
                break;
            case DELETE:
                httpRequest = new HttpDelete(url);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + httpMethod);
        }

        return buildParams(httpRequest, requestWrapper);
    }

    private static ClassicHttpRequest buildParams(ClassicHttpRequest httpRequest, RequestWrapper requestWrapper) {
        httpRequest.setUri(
                UriBuilder.buildUri(httpRequest, requestWrapper)
        );
        return httpRequest;
    }
}
