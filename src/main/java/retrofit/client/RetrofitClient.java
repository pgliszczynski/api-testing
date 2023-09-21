package retrofit.client;

import model.client.HttpClient;
import model.domain.Board;
import model.domain.User;
import model.wrapper.RequestWrapper;
import model.wrapper.ResponseWrapper;
import retrofit.request.RequestSender;
import retrofit2.Call;
import retrofit.request.RequestBuilder;

public class RetrofitClient implements HttpClient {

    private final RequestBuilder requestBuilder;
    private final RequestSender requestSender;

    public RetrofitClient(RequestWrapper requestWrapper) {
        this.requestBuilder = new RequestBuilder(requestWrapper);
        this.requestSender = new RequestSender();
    }

    @Override
    public ResponseWrapper<User> getUserRequest() {
        Call<User> request = requestBuilder.getUserRequest();
        return requestSender.sendUserRequest(request);
    }

    @Override
    public ResponseWrapper<Board> postNewBoard() {
        Call<Board> request = requestBuilder.createBoardRequest();
        return requestSender.sendBoardRequest(request);
    }

    @Override
    public ResponseWrapper<Board> getBoardById(String boardId) {
        Call<Board> request = requestBuilder.getBoardByIdRequest(boardId);
        return requestSender.sendBoardRequest(request);
    }

    @Override
    public ResponseWrapper<Board> updateBoard(String boardId) {
        Call<Board> request = requestBuilder.updateBoardRequest(boardId);
        return requestSender.sendBoardRequest(request);
    }

    @Override
    public ResponseWrapper<Board> deleteBoard(String boardId) {
        Call<Board> request = requestBuilder.deleteBoardRequest(boardId);
        return requestSender.sendBoardRequest(request);
    }
}
