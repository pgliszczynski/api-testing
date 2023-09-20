package utility.request;

import model.Board;
import model.User;
import retrofit2.Call;
import utility.httpclient.service.TrelloService;

import java.util.Map;

public class RetrofitRequestBuilder {
    private final TrelloService trelloService;
    private final Map<String, String> queryParameters;

    public RetrofitRequestBuilder(TrelloService trelloService,
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
