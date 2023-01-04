package com.specialist.code.application.productcreation.exception;

public class ProductAlreadyExistsException extends ProductCustomException {
    public ProductAlreadyExistsException() {
    }

    public ProductAlreadyExistsException(String message) {
        super(message);
    }

    public ProductAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
