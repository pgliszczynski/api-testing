package apache.response.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.domain.User;
import model.wrapper.ResponseWrapper;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;

import java.io.IOException;
import java.util.Optional;

public class UserResponseHandler implements HttpClientResponseHandler<ResponseWrapper<User>> {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ResponseWrapper<User> handleResponse(ClassicHttpResponse classicHttpResponse)
            throws HttpException, IOException {
        int responseCode = classicHttpResponse.getCode();

        Optional<HttpEntity> entity = Optional.ofNullable(classicHttpResponse.getEntity());
        User user = null;
        if(entity.isPresent()) {
            user = objectMapper.readValue(entity.get().getContent(), User.class);
        }

        return new ResponseWrapper<>(responseCode, user);
    }
}
