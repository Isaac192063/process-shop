package com.process.shop.model.enums;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    USER_NOT_FOUND("user not found"),
    USER_EMAIL_EXIST("the email is already registered");

    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }
}
