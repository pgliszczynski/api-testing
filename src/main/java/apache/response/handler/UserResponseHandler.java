package apache.response.handler;

import model.creators.ResponseCreator;
import model.domain.User;
import model.wrapper.ResponseWrapper;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;

import java.io.IOException;

public class UserResponseHandler extends EntityHandler<User>
        implements HttpClientResponseHandler<ResponseWrapper<User>> {

    @Override
    public ResponseWrapper<User> handleResponse(ClassicHttpResponse response) throws IOException {
        int responseCode = response.getCode();
        User user = getEntity(User.class, response);
        return ResponseCreator.createActualResponse(responseCode, user);
    }
}
