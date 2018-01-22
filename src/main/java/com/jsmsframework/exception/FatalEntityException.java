package com.jsmsframework.exception;

public class FatalEntityException extends EntityException {

    public FatalEntityException(String msg) {
        super(msg);
    }

    public FatalEntityException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
