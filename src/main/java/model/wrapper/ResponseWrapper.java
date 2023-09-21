package model.wrapper;

import utility.authorization.AuthorizationUtility;

import java.util.Objects;

public class ResponseWrapper<T> {
    private final int statusCode;
    private final T body;

    public static class Builder<T> {
        private T body;
        private int statusCode;

        public Builder<T> body(T body) {
            this.body = body;
            return this;
        }

        public Builder<T> statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public ResponseWrapper<T> build() {
            return new ResponseWrapper<T>(this);
        }
    }

    private ResponseWrapper(Builder<T> builder) {
        this.body = builder.body;
        this.statusCode = builder.statusCode;
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
