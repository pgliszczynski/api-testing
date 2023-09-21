package model.client;

import model.domain.Board;
import model.domain.User;
import model.wrapper.ResponseWrapper;

public interface HttpClient {

    ResponseWrapper<User> getUserRequest();
    ResponseWrapper<Board> postNewBoard();
    ResponseWrapper<Board> getBoardById(String boardId);
    ResponseWrapper<Board> updateBoard(String boardId);
    ResponseWrapper<Board> deleteBoard(String boardId);
}
