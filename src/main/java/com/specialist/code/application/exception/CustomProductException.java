package com.specialist.code.application.exception;

public class CustomProductException extends Exception{
    public CustomProductException() {
    }

    public CustomProductException(String message) {
        super(message);
    }

    public CustomProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
