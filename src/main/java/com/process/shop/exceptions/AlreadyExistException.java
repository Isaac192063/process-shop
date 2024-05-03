package com.process.shop.exceptions;

public class AlreadyExistException extends RuntimeException {

    public AlreadyExistException(String message) {
        super(message);
    }
}
