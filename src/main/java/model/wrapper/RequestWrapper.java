package model.wrapper;

import java.util.Map;
import java.util.Objects;

public class RequestWrapper<T> {
    private final T body;
    private final Map<String, String> queryParameters;

    public RequestWrapper(T body, Map<String, String> queryParameters) {
        this.body = body;
        this.queryParameters = queryParameters;
    }

    public T getBody() {
        return body;
    }

    public Map<String, String> getQueryParameters() {
        return queryParameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestWrapper<?> that = (RequestWrapper<?>) o;
        return Objects.equals(body, that.body) &&
                Objects.equals(queryParameters, that.queryParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, queryParameters);
    }

    @Override
    public String toString() {
        return "RequestWrapper{" +
                "body=" + body +
                ", queryParameters=" + queryParameters +
                '}';
    }
}
