package apache.response;

import model.domain.Board;
import model.domain.User;
import model.wrapper.ResponseWrapper;
import utility.config.BoardConfig;
import utility.config.UserConfig;

public class ResponseBuilder {

    public static ResponseWrapper<User> getExpectedUserResponse() {
        return new ResponseWrapper<>(
                200,
                new User(
                        UserConfig.getId(),
                        UserConfig.getFullName(),
                        UserConfig.getUsername(),
                        UserConfig.getEmail()
                )
        );
    }

    public static ResponseWrapper<Board> getExpectedBoardResponse() {
        return new ResponseWrapper<>(
                200,
                new Board(
                        "0",
                        BoardConfig.getCreatedBoardName()
                )
        );
    }
}
