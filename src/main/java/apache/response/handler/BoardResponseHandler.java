package apache.response.handler;

import model.creators.ResponseCreator;
import model.domain.Board;
import model.wrapper.ResponseWrapper;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;

import java.io.IOException;

public class BoardResponseHandler extends EntityHandler<Board>
        implements HttpClientResponseHandler<ResponseWrapper<Board>> {

    @Override
    public ResponseWrapper<Board> handleResponse(ClassicHttpResponse response) throws IOException {
        int responseCode = response.getCode();
        Board board = getEntity(Board.class, response);
        return ResponseCreator.createActualResponse(responseCode, board);
    }
}
