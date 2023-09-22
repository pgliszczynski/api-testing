package retrofit.request;

import model.domain.Board;
import model.domain.User;
import model.wrapper.RequestWrapper;
import retrofit.client.service.TrelloService;
import retrofit.client.service.TrelloServiceBuilder;
import retrofit2.Call;

public class RequestBuilder {
    private final RequestWrapper requestWrapper;
    private final TrelloService trelloService;

    public RequestBuilder(RequestWrapper requestWrapper) {
        this.requestWrapper = requestWrapper;
        this.trelloService = TrelloServiceBuilder.buildTrelloService();
    }

    public Call<User> getUserRequest() {
        return trelloService.authorizeUser(requestWrapper.getQueryParameters());
    }

    public Call<Board> createBoardRequest() {
        return trelloService.createBoard(requestWrapper.getQueryParameters());
    }

    public Call<Board> getBoardByIdRequest(String boardId) {
        return trelloService.getBoardById(boardId, requestWrapper.getQueryParameters());
    }

    public Call<Board> updateBoardRequest(String boardId) {
        return trelloService.updateBoard(boardId, requestWrapper.getQueryParameters());
    }

    public Call<Board> deleteBoardRequest(String boardId) {
        return trelloService.deleteBoard(boardId, requestWrapper.getQueryParameters());
    }
}
