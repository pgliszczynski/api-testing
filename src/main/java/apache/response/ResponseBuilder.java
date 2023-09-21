package apache.response;

import model.domain.Board;
import model.domain.User;
import model.response.ResponseDto;
import utility.config.BoardConfig;
import utility.config.UserConfig;

public class ResponseBuilder {

    public static ResponseDto<User> getExpectedUserResponse() {
        return new ResponseDto<>(
                200,
                new User(
                        UserConfig.getId(),
                        UserConfig.getFullName(),
                        UserConfig.getUsername(),
                        UserConfig.getEmail()
                )
        );
    }

    public static ResponseDto<Board> getExpectedBoardResponse() {
        return new ResponseDto<>(
                200,
                new Board(
                        "0",
                        BoardConfig.getCreatedBoardName()
                )
        );
    }
}
