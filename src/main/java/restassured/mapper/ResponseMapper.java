package restassured.mapper;

import io.restassured.response.Response;
import model.domain.Board;
import model.domain.User;
import model.wrapper.ResponseWrapper;

public class ResponseMapper {

    public static ResponseWrapper<User> mapToUserResponse(Response response) {
        return new ResponseWrapper.Builder<User>()
                .statusCode(response.getStatusCode())
                .body(response.as(User.class))
                .build();
    }

    public static ResponseWrapper<Board> mapToBoardResponse(Response response) {
        return new ResponseWrapper.Builder<Board>()
                .statusCode(response.getStatusCode())
                .body(response.as(Board.class))
                .build();
    }
}
