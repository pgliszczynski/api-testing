package model.client;

import model.domain.Board;
import model.domain.User;
import model.response.ResponseDto;

public interface HttpClient {

    ResponseDto<User> getUserRequest();
    ResponseDto<Board> postNewBoard();
    ResponseDto<Board> getBoardById(String boardId);
    ResponseDto<Board> updateBoard(String boardId);
    ResponseDto<Board> deleteBoard(String boardId);
}
