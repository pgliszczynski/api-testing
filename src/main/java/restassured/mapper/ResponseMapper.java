package restassured.mapper;

import io.restassured.response.Response;
import model.domain.Board;
import model.domain.User;
import model.response.ResponseDto;

public class ResponseMapper {

    public static ResponseDto<User> mapToUserResponse(Response response) {
        return new ResponseDto<>(
                response.statusCode(),
                response.as(User.class)
        );
    }

    public static ResponseDto<Board> mapToBoardResponse(Response response) {
        return new ResponseDto<>(
                response.statusCode(),
                response.as(Board.class)
        );
    }
}
