package utility.httpclient;

import model.User;
import model.response.ResponseDto;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.httpclient.authorization.AuthorizationUtility;
import utility.httpclient.request.RequestBuilder;
import utility.httpclient.responsehandler.UserResponseHandler;
import utility.httpclient.url.UrlUtility;

import java.io.IOException;

public class ApacheHttpClient extends HttpClient {

    private final static Logger LOGGER = LoggerFactory.getLogger("Apache Http Client Logger");

    @Override
    public ResponseDto<User> getUserRequest() {
        ClassicHttpRequest request = buildGetUserRequest();

        ResponseDto<User> response = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            response = httpClient.execute(request, new UserResponseHandler());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

        return response;
    }

    private ClassicHttpRequest buildGetUserRequest() {
        return new RequestBuilder(UrlUtility.getUserUrl())
                .addParameter(
                        "key",
                        AuthorizationUtility.getApiKey())
                .addParameter(
                        "token",
                        AuthorizationUtility.getTrelloToken())
                .get()
                .build();
    }
}
