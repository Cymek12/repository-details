package com.example.repository_details.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WebException extends RuntimeException {
    private final Integer status;
    private final String error;
    private final String message;
}