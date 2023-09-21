package retrofit.response;

import model.domain.Board;
import model.domain.User;
import model.wrapper.ResponseWrapper;
import retrofit2.Response;

public class ResponseMapper {

    public static ResponseWrapper<User> mapToUserResponse(Response<User> response) {
        return new ResponseWrapper.Builder<User>()
                .statusCode(response.code())
                .body(response.body())
                .build();
    }

    public static ResponseWrapper<Board> mapToBoardResponse(Response<Board> response) {
        return new ResponseWrapper.Builder<Board>()
                .statusCode(response.code())
                .body(response.body())
                .build();
    }
}
