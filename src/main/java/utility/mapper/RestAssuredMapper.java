package utility.mapper;

import io.restassured.response.Response;
import model.Board;
import model.User;
import model.response.ResponseDto;

public class RestAssuredMapper {

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
