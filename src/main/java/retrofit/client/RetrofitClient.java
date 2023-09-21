package retrofit.client;

import model.client.HttpClient;
import model.domain.Board;
import model.domain.User;
import model.response.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import utility.config.BoardConfig;
import retrofit.client.service.TrelloService;
import retrofit.client.parameters.ParametersBuilder;
import retrofit.request.RequestBuilder;
import retrofit.request.RequestSender;
import utility.url.UrlUtility;

import java.util.Map;

public class RetrofitClient implements HttpClient {
    private final TrelloService trelloService;
    private Map<String, String> queryParameters;
    private RequestBuilder retrofitRequestBuilder;

    private final static Logger LOGGER = LoggerFactory.getLogger("Retrofit Client");

    public RetrofitClient() {
        LOGGER.info("Creating Retrofit Client");
        Retrofit retrofit = buildRetrofit();
        LOGGER.info("Creating TrelloService");
        this.trelloService = retrofit.create(TrelloService.class);
    }

    private Retrofit buildRetrofit() {
        LOGGER.info("Creating Retrofit");
        return new Retrofit.Builder()
                .baseUrl(UrlUtility.getBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Override
    public ResponseDto<User> getUserRequest() {
        createAuthorizationParameters();

        createRequestBuilder();
        Call<User> request = createUserRequest();

        return sendUserRequest(request);
    }

    @Override
    public ResponseDto<Board> postNewBoard() {
        createAuthorizationParameters();
        addNameParameter(
                BoardConfig.getCreatedBoardName()
        );

        createRequestBuilder();
        Call<Board> request = createBoardRequest();

        return sendBoardRequest(request);
    }

    @Override
    public ResponseDto<Board> getBoardById(String boardId) {
        createAuthorizationParameters();

        createRequestBuilder();
        Call<Board> request = createGetBoardByIdRequest(boardId);
        return sendBoardRequest(request);
    }

    @Override
    public ResponseDto<Board> updateBoard(String boardId) {
        return null;
    }

    @Override
    public ResponseDto<Board> deleteBoard(String boardId) {
        return null;
    }

    private void createAuthorizationParameters() {
        LOGGER.info("Add Authorization parameters to url path");
        queryParameters = new ParametersBuilder()
                .addAuthorization()
                .build();
    }


    private void addNameParameter(String name) {
        LOGGER.info("Adding name parameter");
        queryParameters.put(
                "name",
                name
        );
    }

    private void createRequestBuilder() {
        retrofitRequestBuilder = new RequestBuilder(
                trelloService,
                queryParameters
        );
    }

    private Call<User> createUserRequest() {
        LOGGER.info("Create request for getting user");
        return retrofitRequestBuilder.getUserRequest();
    }

    private Call<Board> createBoardRequest() {
        LOGGER.info("Create request for creating board");
        return retrofitRequestBuilder.createBoardRequest();
    }


    private Call<Board> createGetBoardByIdRequest(String boardId) {
        LOGGER.info("Create request for getting board by Id");
        return retrofitRequestBuilder.getBoardByIdRequest(boardId);
    }

    private ResponseDto<User> sendUserRequest(Call<User> request) {
        LOGGER.info("Starting to send request");
        RequestSender<User> sender = new RequestSender<>();
        return sender.sendRequest(request);
    }

    private ResponseDto<Board> sendBoardRequest(Call<Board> request) {
        LOGGER.info("Starting to send request");
        RequestSender<Board> sender = new RequestSender<>();
        return sender.sendRequest(request);
    }
}
