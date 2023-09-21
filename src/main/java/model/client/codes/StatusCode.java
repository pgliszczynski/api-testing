package model.client.codes;

public enum StatusCode {
    OK(200);

    private final int statusCode;

    StatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int get() {
        return statusCode;
    }
}
