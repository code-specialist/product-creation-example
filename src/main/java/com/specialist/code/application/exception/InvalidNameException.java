package com.specialist.code.application.exception;

public class InvalidNameException extends CustomProductException{
    public InvalidNameException() {
    }

    public InvalidNameException(String message) {
        super(message);
    }

    public InvalidNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
