package utility.response.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import model.response.ResponseDto;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;

import java.io.IOException;
import java.util.Optional;

public class UserResponseHandler implements HttpClientResponseHandler<ResponseDto<User>> {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ResponseDto<User> handleResponse(ClassicHttpResponse classicHttpResponse)
            throws HttpException, IOException {
        int responseCode = classicHttpResponse.getCode();

        Optional<HttpEntity> entity = Optional.ofNullable(classicHttpResponse.getEntity());
        User user = new User();
        if(entity.isPresent()) {
            user = objectMapper.readValue(entity.get().getContent(), User.class);
        }

        return new ResponseDto<>(responseCode, user);
    }
}
