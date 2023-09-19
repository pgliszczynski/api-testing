package utility.httpclient;

import model.User;
import model.response.ResponseDto;

public abstract class HttpClient {

    public abstract ResponseDto<User> getUserRequest();
}
