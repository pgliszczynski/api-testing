package utility.httpclient;

import model.User;
import model.response.ResponseDto;

public interface HttpClient {

    ResponseDto<User> getUserRequest();
}
