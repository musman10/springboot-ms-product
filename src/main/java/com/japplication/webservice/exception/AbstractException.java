package com.japplication.webservice.exception;

public abstract class AbstractException extends RuntimeException {

    public AbstractException() {
        super();
    }

    public AbstractException(String message) {
        super(message);
    }
}
