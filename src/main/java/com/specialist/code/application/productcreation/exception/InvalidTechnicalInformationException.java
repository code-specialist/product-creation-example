package com.specialist.code.application.productcreation.exception;

public class InvalidTechnicalInformationException extends ProductCustomException {
    public InvalidTechnicalInformationException() {
    }

    public InvalidTechnicalInformationException(String message) {
        super(message);
    }

    public InvalidTechnicalInformationException(String message, Throwable cause) {
        super(message, cause);
    }
}
