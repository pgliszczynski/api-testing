package apache.request;

import apache.response.handler.BoardResponseHandler;
import apache.response.handler.UserResponseHandler;
import model.domain.Board;
import model.domain.User;
import model.wrapper.ResponseWrapper;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RequestSender {
    private final static Logger LOGGER = LoggerFactory.getLogger("Request Sender Logger");

    public ResponseWrapper<User> sendUserRequest(ClassicHttpRequest request) {
        ResponseWrapper<User> response = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            response = httpClient.execute(request, new UserResponseHandler());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return response;
    }

    public ResponseWrapper<Board> sendBoardRequest(ClassicHttpRequest request) {
        ResponseWrapper<Board> response = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            response = httpClient.execute(request, new BoardResponseHandler());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return response;
    }
}
