package com.example.repository_details.exception;

public class RepositoryAlreadyExistsException extends WebException {
    public RepositoryAlreadyExistsException(String message) {
        super(400, "Bad request", message);
    }
}