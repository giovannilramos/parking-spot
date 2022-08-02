package com.api.exceptions;

public class Exceptions extends RuntimeException {
    private final Integer code;
    public Exceptions(final String msg, final Integer code) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
