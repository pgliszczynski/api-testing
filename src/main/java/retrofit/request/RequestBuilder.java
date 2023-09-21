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

    public Call<User> userRequest() {
        return trelloService.authorizeUser(queryParameters);
    }

    public Call<Board> boardRequest() {
        return trelloService.createBoard(queryParameters);
    }
}
