package com.specialist.code.application.productcreation.exception;

public class InvalidNameException extends ProductCustomException {
    public InvalidNameException() {
    }

    public InvalidNameException(String message) {
        super(message);
    }

    public InvalidNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
