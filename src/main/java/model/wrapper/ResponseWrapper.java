package model.wrapper;

import java.util.Objects;

public class ResponseWrapper<T> {
    private final int statusCode;
    private final T body;

    public ResponseWrapper(int statusCode, T t) {
        this.statusCode = statusCode;
        this.body = t;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public T getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseWrapper<?> that = (ResponseWrapper<?>) o;
        return statusCode == that.statusCode &&
                Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, body);
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "statusCode=" + statusCode +
                ", t=" + body +
                '}';
    }
}
