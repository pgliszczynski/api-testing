package retrofit.request;

import model.domain.Board;
import model.domain.User;
import retrofit2.Call;
import retrofit.client.service.TrelloService;

import java.util.Map;

public class RequestBuilder {
    private final TrelloService trelloService;
    private final Map<String, String> queryParameters;

    public RequestBuilder(TrelloService trelloService,
                          Map<String, String> queryParameters) {
        this.trelloService = trelloService;
        this.queryParameters = queryParameters;
    }

    public Call<User> getUserRequest() {
        return trelloService.authorizeUser(queryParameters);
    }

    public Call<Board> createBoardRequest() {
        return trelloService.createBoard(queryParameters);
    }

    public Call<Board> getBoardByIdRequest(String boardId) {
        return trelloService.getBoardById(boardId, queryParameters);
    }

    public Call<Board> updateBoardRequest(String boardId) {
        return trelloService.updateBoard(boardId, queryParameters);
    }
}
