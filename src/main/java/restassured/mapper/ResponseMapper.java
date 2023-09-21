package restassured.mapper;

import io.restassured.response.Response;
import model.domain.Board;
import model.domain.User;
import model.wrapper.ResponseWrapper;

public class ResponseMapper {

    public static ResponseWrapper<User> mapToUserResponse(Response response) {
        return new ResponseWrapper<>(
                response.statusCode(),
                response.as(User.class)
        );
    }

    public static ResponseWrapper<Board> mapToBoardResponse(Response response) {
        return new ResponseWrapper<>(
                response.statusCode(),
                response.as(Board.class)
        );
    }
}
