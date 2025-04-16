package com.example.repository_details.exception;

import org.springframework.http.HttpStatus;

public class RepositoryAlreadyExistsException extends WebException {
    public RepositoryAlreadyExistsException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}