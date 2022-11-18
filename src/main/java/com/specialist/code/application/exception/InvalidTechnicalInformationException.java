package com.specialist.code.application.exception;

public class InvalidTechnicalInformationException extends CustomProductException{
    public InvalidTechnicalInformationException() {
    }

    public InvalidTechnicalInformationException(String message) {
        super(message);
    }

    public InvalidTechnicalInformationException(String message, Throwable cause) {
        super(message, cause);
    }
}
