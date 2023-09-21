package retrofit.client.service;

import model.domain.Board;
import model.domain.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface TrelloService {

    @Headers("Accept: application/json")
    @GET("members/me")
    Call<User> authorizeUser(@QueryMap Map<String, String> options);

    @Headers("Accept: application/json")
    @POST("board")
    Call<Board> createBoard(@QueryMap Map<String, String> queryParameters);

    @Headers("Accept: application/json")
    @GET("board/{boardId}")
    Call<Board> getBoardById(@Path("boardId") String boardId,
                             @QueryMap Map<String, String> queryParameters);

    @Headers("Accept: application/json")
    @PUT("board/{boardId}")
    Call<Board> updateBoard(@Path("boardId") String boardId,
                            @QueryMap Map<String, String> queryParameters);
}
