package apache.request;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.authorization.AuthorizationUtility;
import model.client.methods.HttpMethod;

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
        LOGGER.info("Request url set to: " + url);
        this.url = url;
        urlParameters = new ArrayList<>();
    }

    public RequestBuilder get() {
        LOGGER.info("Request method set to GET");
        this.httpMethod = HttpMethod.GET;
        return this;
    }

    public RequestBuilder post() {
        LOGGER.info("Request method set to POST");
        this.httpMethod = HttpMethod.POST;
        return this;
    }

    public RequestBuilder put() {
        LOGGER.info("Request method set to PUT");
        this.httpMethod = HttpMethod.PUT;
        return this;
    }

    public RequestBuilder delete() {
        LOGGER.info("Request method set to DELETE");
        this.httpMethod = HttpMethod.DELETE;
        return this;
    }

    public RequestBuilder addParameter(String param, String value) {
        LOGGER.info("Request parameter: " + param + " added");
        urlParameters.add(new BasicNameValuePair(param, value));
        return this;
    }

    public RequestBuilder addTrelloValidation() {
        LOGGER.info("Adding Trello validation API_KEY and token");
        this.addParameter(
                "key",
                AuthorizationUtility.getApiKey());
        this.addParameter(
                "token",
                AuthorizationUtility.getTrelloToken());
        return this;
    }

    public ClassicHttpRequest build() {
        LOGGER.info("Started building request");
        httpRequest = RequestFactory.createRequest(httpMethod, url);
        buildParams();
        LOGGER.info("Request built");
        return httpRequest;
    }

    private void buildParams() {
        LOGGER.info("Started building request parameters");
        httpRequest.setUri(buildUri());
        LOGGER.info("Params built and set to request");
    }

    private URI buildUri() {
        LOGGER.info("Started building URI");
        URI uri = null;
        try {
            uri = new URIBuilder(httpRequest.getUri())
                    .addParameters(urlParameters)
                    .build();
        } catch (URISyntaxException e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("Finished building URI");
        return uri;
    }
}
