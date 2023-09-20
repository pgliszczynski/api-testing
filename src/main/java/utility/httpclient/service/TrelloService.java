package utility.httpclient.service;

import model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface TrelloService {

    @Headers("Accept: application/json")
    @GET("members/me")
    Call<User> authorizeUser(@QueryMap Map<String, String> options);
}
