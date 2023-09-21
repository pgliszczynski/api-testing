package apache.request;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.core5.http.ClassicHttpRequest;
import model.methods.HttpMethod;

public class RequestFactory {

    public static ClassicHttpRequest createRequest(HttpMethod httpMethod, String url) {
        switch (httpMethod) {
            case GET:
                return new HttpGet(url);
            case PUT:
                return new HttpPut(url);
            case POST:
                return new HttpPost(url);
            case DELETE:
                return new HttpDelete(url);
        }
        return null;
    }
}
