package utility.httpclient.request;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.httpclient.request.methods.HttpMethod;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class RequestBuilder {
    private String url;
    private List<NameValuePair> urlParameters;
    private HttpMethod httpMethod;
    private ClassicHttpRequest httpRequest;

    private final static Logger LOGGER = LoggerFactory.getLogger("Request Builder Logger");

    public RequestBuilder(String url) {
        this.url = url;
        urlParameters = new ArrayList<>();
    }

    public RequestBuilder get() {
        this.httpMethod = HttpMethod.GET;
        return this;
    }

    public RequestBuilder addParameter(String param, String value) {
        urlParameters.add(new BasicNameValuePair(param, value));
        return this;
    }

    public ClassicHttpRequest build() {
        httpRequest = RequestFactory.createRequest(httpMethod, url);
        buildParams();
        return httpRequest;
    }

    private void buildParams() {
        httpRequest.setUri(buildUri());
    }

    private URI buildUri() {
        URI uri = null;
        try {
            uri = new URIBuilder(httpRequest.getUri())
                    .addParameters(urlParameters)
                    .build();
        } catch (URISyntaxException e) {
            LOGGER.error(e.getMessage());
        }
        return uri;
    }
}
