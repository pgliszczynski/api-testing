package model.creators;

import model.client.codes.StatusCode;
import model.domain.Board;
import model.domain.User;
import model.wrapper.ResponseWrapper;
import utility.config.BoardConfig;
import utility.config.UserConfig;

public class ResponseCreator {

    public static ResponseWrapper<User> getUserResponse() {
        return new ResponseWrapper.Builder<User>()
                .statusCode(StatusCode.OK.get())
                .body(new User(
                        UserConfig.getId(),
                        UserConfig.getFullName(),
                        UserConfig.getUsername(),
                        UserConfig.getEmail()))
                .build();
    }

    public static ResponseWrapper<Board> getBoardResponse() {
        return new ResponseWrapper.Builder<Board>()
                .statusCode(StatusCode.OK.get())
                .body(new Board(
                        null,
                        BoardConfig.getCreatedBoardName()))
                .build();
    }

    public static ResponseWrapper<Board> getUpdatedBoardResponse() {
        return new ResponseWrapper.Builder<Board>()
                .statusCode(StatusCode.OK.get())
                .body(new Board(
                        null,
                        BoardConfig.getUpdatedBoardName()))
                .build();
    }

    public static ResponseWrapper<User> createActualResponse(int statusCode, User user) {
        return new ResponseWrapper.Builder<User>()
                .statusCode(statusCode)
                .body(user)
                .build();
    }

    public static ResponseWrapper<Board> createActualResponse(int statusCode, Board board) {
        return new ResponseWrapper.Builder<Board>()
                .statusCode(statusCode)
                .body(board)
                .build();
    }
}
