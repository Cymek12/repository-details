package com.example.repository_details.exception;

import org.springframework.http.HttpStatus;

public class RepositoryNotFoundException extends WebException {
    public RepositoryNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}