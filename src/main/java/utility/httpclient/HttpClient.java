package utility.httpclient;

import model.Board;
import model.User;
import model.response.ResponseDto;

public interface HttpClient {

    ResponseDto<User> getUserRequest();
    ResponseDto<Board> postNewBoard();
    ResponseDto<Board> getBoardById(String boardId);
    ResponseDto<Board> updateBoard(String boardId);
}
