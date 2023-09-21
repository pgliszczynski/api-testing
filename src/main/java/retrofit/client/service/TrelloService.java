package retrofit.client.service;

import model.domain.Board;
import model.domain.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface TrelloService {

    @Headers("Accept: application/json")
    @GET("members/me")
    Call<User> authorizeUser(@QueryMap Map<String, String> options);

    @Headers("Accept: application/json")
    @POST("board")
    Call<Board> createBoard(@QueryMap Map<String, String> queryParameters);
}
