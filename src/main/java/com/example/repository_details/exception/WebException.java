package com.example.repository_details.exception;

import lombok.Getter;

@Getter
public class WebException extends RuntimeException {
    private final Integer status;
    private final String error;
    private final String message;

    public WebException(Integer status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }
}