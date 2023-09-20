package utility.httpclient;

import model.Board;
import model.User;
import model.response.ResponseDto;
import org.apache.hc.core5.http.ClassicHttpRequest;
import utility.config.BoardConfig;
import utility.request.RequestBuilder;
import utility.request.RequestSender;
import utility.url.UrlUtility;

public class ApacheHttpClient implements HttpClient {
    private ClassicHttpRequest request;
    private RequestSender requestSender;

    @Override
    public ResponseDto<User> getUserRequest() {
        createUserGetRequest();
        return requestSender.sendUserRequest();
    }

    @Override
    public ResponseDto<Board> postNewBoard() {
        createBoardPostRequest();
        return requestSender.sendBoardRequest();
    }

    @Override
    public ResponseDto<Board> getBoardById(String boardId) {
        createBoardGetRequest(boardId);
        return requestSender.sendBoardRequest();
    }

    private void createUserGetRequest() {
        request = new RequestBuilder(UrlUtility.getUserUrl())
                .addTrelloValidation()
                .get()
                .build();
        createRequestSender();
    }

    private void createBoardPostRequest() {
        request = new RequestBuilder(UrlUtility.geBoardUrl())
                .addParameter(
                        "name",
                        BoardConfig.getCreatedBoardName()
                )
                .addTrelloValidation()
                .post()
                .build();
        createRequestSender();
    }

    private void createBoardGetRequest(String boardId) {
        request = new RequestBuilder(UrlUtility.getBoardUrlWithId(boardId))
                .addTrelloValidation()
                .get()
                .build();
    }

    private void createRequestSender() {
        requestSender = new RequestSender(request);
    }
}
