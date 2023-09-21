package apache.client;

import model.domain.Board;
import model.domain.User;
import model.response.ResponseDto;
import org.apache.hc.core5.http.ClassicHttpRequest;
import utility.config.BoardConfig;
import model.client.HttpClient;
import apache.request.RequestBuilder;
import apache.request.RequestSender;
import utility.url.UrlUtility;

public class ApacheClient implements HttpClient {
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

    @Override
    public ResponseDto<Board> updateBoard(String boardId) {
        createBoardPutRequest(boardId);
        return requestSender.sendBoardRequest();
    }

    @Override
    public ResponseDto<Board> deleteBoard(String boardId) {
        createBoardDeleteRequest(boardId);
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
        request = new RequestBuilder(UrlUtility.getBoardUrl())
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
        createRequestSender();
    }

    private void createBoardPutRequest(String boardId) {
        request = new RequestBuilder(UrlUtility.getBoardUrlWithId(boardId))
                .addParameter(
                        "name",
                        BoardConfig.getUpdatedBoardName()
                )
                .addTrelloValidation()
                .put()
                .build();
        createRequestSender();
    }

    private void createBoardDeleteRequest(String boardId) {
        request = new RequestBuilder(UrlUtility.getBoardUrlWithId(boardId))
                .addTrelloValidation()
                .delete()
                .build();
        createRequestSender();
    }

    private void createRequestSender() {
        requestSender = new RequestSender(request);
    }
}
