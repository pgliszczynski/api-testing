package apache.response.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

public abstract class EntityHandler<T> {
    private ObjectMapper objectMapper = new ObjectMapper();

    private final static Logger LOGGER = LoggerFactory.getLogger("Entity handler");

    public T getEntity(Class<T> t, ClassicHttpResponse response) throws IOException {
        Optional<HttpEntity> entity = Optional.ofNullable(response.getEntity());

        T body = null;
        if(entity.isPresent()) {
            body = objectMapper.readValue(entity.get().getContent(), t);
        } else {
            LOGGER.error("Empty response entity");
        }

        return body;
    }
}
