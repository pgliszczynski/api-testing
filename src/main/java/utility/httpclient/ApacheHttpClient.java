package utility.httpclient;

import model.User;
import model.response.ResponseDto;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.net.URIBuilder;
import utility.httpclient.responsehandler.UserResponseHandler;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ApacheHttpClient extends HttpClient {

    @Override
    public ResponseDto<User> getUserRequest() {
        HttpGet request = new HttpGet("https://api.trello.com/1/members/me");

        try {
            URI uri = new URIBuilder(request.getUri())
                    .addParameter(
                            "key",
                            "b62bb764cf339a96a65de5f0de87797e")
                    .addParameter(
                            "token",
                            "ATTA1f67913eefc974bad052034cd15bd0d65c807a415900d79b347137ce97a99b05175E9406")
                    .build();
            request.setUri(uri);
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }

        ResponseDto<User> response = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            response = httpClient.execute(request, new UserResponseHandler());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return response;
    }
}
