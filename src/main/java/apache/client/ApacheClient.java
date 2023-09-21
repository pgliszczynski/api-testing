package apache.client;

import model.domain.Board;
import model.domain.User;
import model.wrapper.RequestWrapper;
import model.wrapper.ResponseWrapper;
import org.apache.hc.core5.http.ClassicHttpRequest;
import model.client.HttpClient;
import apache.request.RequestBuilder;
import apache.request.RequestSender;

public class ApacheClient implements HttpClient {
    private final RequestBuilder requestBuilder;
    private final RequestSender requestSender;

    public ApacheClient(RequestWrapper requestWrapper) {
        this.requestBuilder = new RequestBuilder(requestWrapper);
        this.requestSender = new RequestSender();
    }

    @Override
    public ResponseWrapper<User> getUserRequest() {
        ClassicHttpRequest request = requestBuilder.createGetUserRequest();
        return requestSender.sendUserRequest(request);
    }

    @Override
    public ResponseWrapper<Board> postNewBoard() {
        ClassicHttpRequest request = requestBuilder.createPostBoardRequest();
        return requestSender.sendBoardRequest(request);
    }

    @Override
    public ResponseWrapper<Board> getBoardById(String boardId) {
        ClassicHttpRequest request = requestBuilder.createGetBoardByIdRequest(boardId);
        return requestSender.sendBoardRequest(request);
    }

    @Override
    public ResponseWrapper<Board> updateBoard(String boardId) {
        ClassicHttpRequest request = requestBuilder.createUpdateBoardRequest(boardId);
        return requestSender.sendBoardRequest(request);
    }

    @Override
    public ResponseWrapper<Board> deleteBoard(String boardId) {
        ClassicHttpRequest request = requestBuilder.createDeleteBoardRequest(boardId);
        return requestSender.sendBoardRequest(request);
    }
}
