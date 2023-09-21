package apache.request.uri;

import apache.parameters.ParametersMapper;
import model.wrapper.RequestWrapper;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class UriBuilder {
    private final static Logger LOGGER = LoggerFactory.getLogger("Apache: Uri Builder");

    public static URI buildUri(ClassicHttpRequest httpRequest, RequestWrapper request) {
        URI uri = null;
        List<NameValuePair> queryParameters = mapParameters(request);

        try {
            uri = new URIBuilder(httpRequest.getUri())
                    .addParameters(queryParameters)
                    .build();
        } catch (URISyntaxException e) {
            LOGGER.error(e.getMessage());
        }

        return uri;
    }

    private static List<NameValuePair> mapParameters(RequestWrapper request) {
        return ParametersMapper.mapToList(request.getQueryParameters());
    }
}
