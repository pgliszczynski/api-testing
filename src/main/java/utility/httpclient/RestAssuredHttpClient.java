package utility.httpclient;

import model.Board;
import model.User;
import model.response.ResponseDto;

public class RestAssuredHttpClient implements HttpClient {
    @Override
    public ResponseDto<User> getUserRequest() {
        return null;
    }

    @Override
    public ResponseDto<Board> postNewBoard() {
        return null;
    }

    @Override
    public ResponseDto<Board> getBoardById(String boardId) {
        return null;
    }

    @Override
    public ResponseDto<Board> updateBoard(String boardId) {
        return null;
    }

    @Override
    public ResponseDto<Board> deleteBoard(String boardId) {
        return null;
    }
}
