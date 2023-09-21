package retrofit.request;

import model.domain.Board;
import model.domain.User;
import model.wrapper.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.response.ResponseMapper;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class RequestSender {

    private final static Logger LOGGER = LoggerFactory.getLogger("Retrofit Request Sender");

    public ResponseWrapper<User> sendUserRequest(Call<User> request) {
        ResponseWrapper<User> responseWrapper = null;
        try {
            Response<User> response = request.execute();
            responseWrapper = ResponseMapper.mapToUserResponse(response);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return responseWrapper;
    }

    public ResponseWrapper<Board> sendBoardRequest(Call<Board> request) {
        ResponseWrapper<Board> responseWrapper = null;
        try {
            Response<Board> response = request.execute();
            responseWrapper = ResponseMapper.mapToBoardResponse(response);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return responseWrapper;
    }
}
