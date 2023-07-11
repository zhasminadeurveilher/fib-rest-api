package com.fib.fibrestapi.exception;

import org.springframework.http.HttpStatus;

public class FibException extends RuntimeException{

    private HttpStatus status;
    private String message;

    public FibException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public FibException(HttpStatus status, String message, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
