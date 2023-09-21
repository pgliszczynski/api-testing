package apache.response.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.domain.Board;
import model.wrapper.ResponseWrapper;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;

import java.io.IOException;
import java.util.Optional;

public class BoardResponseHandler implements HttpClientResponseHandler<ResponseWrapper<Board>> {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ResponseWrapper<Board> handleResponse(ClassicHttpResponse classicHttpResponse)
            throws HttpException, IOException {
        int responseCode = classicHttpResponse.getCode();

        Optional<HttpEntity> entity = Optional.ofNullable(classicHttpResponse.getEntity());
        Board board = null;
        if(entity.isPresent()) {
            board = objectMapper.readValue(entity.get().getContent(), Board.class);
        }

        return new ResponseWrapper<>(responseCode, board);
    }
}
