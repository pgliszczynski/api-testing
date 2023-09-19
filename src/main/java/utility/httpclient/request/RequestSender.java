package utility.httpclient.request;

import model.User;
import model.response.ResponseDto;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.httpclient.responsehandler.UserResponseHandler;

import java.io.IOException;

public class RequestSender {
    private final ClassicHttpRequest request;

    private final static Logger LOGGER = LoggerFactory.getLogger("Request Sender Logger");

    public RequestSender(ClassicHttpRequest request) {
        this.request = request;
    }

    public ResponseDto<User> sendUserRequest() {
        ResponseDto<User> response = null;
        LOGGER.info("Trying to send request");
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            LOGGER.info("Sending request");
            response = httpClient.execute(request, new UserResponseHandler());
            LOGGER.info("Request successfully sent");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return response;
    }
}
