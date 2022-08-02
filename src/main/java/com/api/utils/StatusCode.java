package com.api.utils;

public enum StatusCode {
    NOT_FOUND(404),
    ALREADY_EXISTS(409);

    private final Integer statusCode;
    StatusCode(final Integer code) {
        this.statusCode = code;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
