package utility.response.builder;

import model.User;
import model.response.ResponseDto;
import utility.config.UserConfig;

public class ResponseBuilder {

    public static ResponseDto<User> getExpectedUserResponse() {
        return new ResponseDto<>(
                200,
                new User(
                        UserConfig.getId(),
                        UserConfig.getFullName(),
                        UserConfig.getUsername(),
                        UserConfig.getEmail()
                )
        );
    }
}
