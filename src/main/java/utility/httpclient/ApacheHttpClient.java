package utility.httpclient;

import model.Board;
import model.User;
import model.response.ResponseDto;
import org.apache.hc.core5.http.ClassicHttpRequest;
import utility.authorization.AuthorizationUtility;
import utility.config.BoardConfig;
import utility.request.RequestBuilder;
import utility.request.RequestSender;
import utility.url.UrlUtility;

public class ApacheHttpClient implements HttpClient {

    @Override
    public ResponseDto<User> getUserRequest() {
        ClassicHttpRequest request = buildUserGetRequest();
        RequestSender requestSender = new RequestSender(request);
        return requestSender.sendUserRequest();
    }

    @Override
    public ResponseDto<Board> postNewBoard() {
        ClassicHttpRequest request = buildBoardPostRequest();
        RequestSender requestSender = new RequestSender(request);
        return requestSender.sendBoardRequest();
    }

    private ClassicHttpRequest buildUserGetRequest() {
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

    private ClassicHttpRequest buildBoardPostRequest() {
        return new RequestBuilder(UrlUtility.geBoardUrl())
                .addParameter(
                        "key",
                        AuthorizationUtility.getApiKey())
                .addParameter(
                        "token",
                        AuthorizationUtility.getTrelloToken())
                .addParameter(
                        "name",
                        BoardConfig.getCreatedBoardName()
                )
                .post()
                .build();
    }
}
