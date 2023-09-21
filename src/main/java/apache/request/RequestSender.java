package apache.request;

import model.domain.Board;
import model.domain.User;
import model.wrapper.ResponseWrapper;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import apache.response.handler.BoardResponseHandler;
import apache.response.handler.UserResponseHandler;

import java.io.IOException;

public class RequestSender {
    private final ClassicHttpRequest request;

    private final static Logger LOGGER = LoggerFactory.getLogger("Request Sender Logger");

    public RequestSender(ClassicHttpRequest request) {
        this.request = request;
    }

    public ResponseWrapper<User> sendUserRequest() {
        ResponseWrapper<User> response = null;
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

    public ResponseWrapper<Board> sendBoardRequest() {
        ResponseWrapper<Board> response = null;
        LOGGER.info("Trying to send request");
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            LOGGER.info("Sending request");
            response = httpClient.execute(request, new BoardResponseHandler());
            LOGGER.info("Request successfully sent");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return response;
    }
}
