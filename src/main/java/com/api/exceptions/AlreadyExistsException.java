package com.api.exceptions;

public class AlreadyExistsException extends Exceptions {
    public AlreadyExistsException(final String msg, final Integer code) {
        super(msg, code);
    }
}
