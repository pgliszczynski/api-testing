package utility.httpclient;

import model.Board;
import model.User;
import model.response.ResponseDto;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import utility.httpclient.service.TrelloService;
import utility.url.UrlUtility;

public class RetrofitClient implements HttpClient {
    private final TrelloService trelloService;

    public RetrofitClient() {
        Retrofit retrofit = buildRetrofit();
        this.trelloService = retrofit.create(TrelloService.class);
    }

    private Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(UrlUtility.getBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Override
    public ResponseDto<User> getUserRequest() {
        return null;
    }

    @Override
    public ResponseDto<Board> postNewBoard() {
        return null;
    }

    @Override
    public ResponseDto<Board> getBoardById(String boardId) {
        return null;
    }

    @Override
    public ResponseDto<Board> updateBoard(String boardId) {
        return null;
    }

    @Override
    public ResponseDto<Board> deleteBoard(String boardId) {
        return null;
    }
}
