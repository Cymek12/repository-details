package com.example.repository_details.exception;

public class RepositoryNotFoundException extends WebException {
    public RepositoryNotFoundException(String message) {
        super(404, "Not found", message);
    }
}