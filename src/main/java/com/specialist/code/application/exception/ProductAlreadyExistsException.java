package com.specialist.code.application.exception;

public class ProductAlreadyExistsException extends CustomProductException{
    public ProductAlreadyExistsException() {
    }

    public ProductAlreadyExistsException(String message) {
        super(message);
    }

    public ProductAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
