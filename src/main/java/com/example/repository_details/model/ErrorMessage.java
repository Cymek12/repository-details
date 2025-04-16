package com.example.repository_details.model;

import lombok.Builder;

import java.util.Date;

@Builder
public record ErrorMessage(Integer status, String error, String message, Date timestamp) {
}