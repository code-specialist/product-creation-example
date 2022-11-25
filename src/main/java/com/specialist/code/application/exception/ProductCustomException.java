package com.specialist.code.application.exception;

public class ProductCustomException extends Exception{
    public ProductCustomException() {
    }

    public ProductCustomException(String message) {
        super(message);
    }

    public ProductCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
