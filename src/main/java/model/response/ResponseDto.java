package model.response;

import model.User;

public class ResponseDto<T> {
    private final int statusCode;
    private final T t;

    public ResponseDto(int statusCode, T t) {
        this.statusCode = statusCode;
        this.t = t;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public T getT() {
        return t;
    }
}
