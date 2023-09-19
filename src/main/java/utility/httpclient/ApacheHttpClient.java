package utility.httpclient;

import model.User;
import model.response.ResponseDto;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.httpclient.request.RequestBuilder;
import utility.httpclient.responsehandler.UserResponseHandler;

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
        return new RequestBuilder("https://api.trello.com/1/members/me")
                .addParameter(
                        "key",
                        "b62bb764cf339a96a65de5f0de87797e")
                .addParameter(
                        "token",
                        "ATTA1f67913eefc974bad052034cd15bd0d65c807a415900d79b347137ce97a99b05175E9406")
                .get()
                .build();
    }
}
