package com.example.repository_details.model;

import lombok.Builder;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Builder
public record ErrorMessage(@NonNull String message, HttpStatus httpStatus, Date date) {
}