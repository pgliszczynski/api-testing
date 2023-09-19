package model.response;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDto<?> that = (ResponseDto<?>) o;
        return statusCode == that.statusCode &&
                Objects.equals(t, that.t);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, t);
    }
}
