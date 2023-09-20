package utility.request;

import model.response.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class RetrofitRequestSender<T> {
    private ResponseDto<T> response;

    private final static Logger LOGGER = LoggerFactory.getLogger("Retrofit Request Sender");

    public ResponseDto<T> sendRequest(Call<T> request) {
        LOGGER.info("Sending request");
        try {
            Response<T> response = request.execute();
            this.response = new ResponseDto<>(
                    response.code(),
                    response.body()
            );
            LOGGER.info("Request sent successfully");
        } catch (IOException e) {
            LOGGER.error("Request could not be sent!");
            LOGGER.error(e.getMessage());
        }
        return response;
    }
}
