package retrofit.client.service;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import utility.url.UrlUtility;

public class TrelloServiceBuilder {

    public static TrelloService buildTrelloService() {
        Retrofit retrofit = buildRetrofit();
        return retrofit.create(TrelloService.class);
    }

    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(UrlUtility.getBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
