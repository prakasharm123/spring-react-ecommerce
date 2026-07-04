package com.telusko.springecom.exceptions;

public class ProductImageNotFoundException extends RuntimeException {
    public ProductImageNotFoundException(String message) {
        super(message);
    }
}
