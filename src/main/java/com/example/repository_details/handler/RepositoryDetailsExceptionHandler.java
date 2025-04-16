package com.example.repository_details.handler;

import com.example.repository_details.exception.WebException;
import com.example.repository_details.model.ErrorMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class RepositoryDetailsExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(WebException.class)
    public ErrorMessage handleWebException(WebException ex) {
        return new ErrorMessage(ex.getMessage(), ex.getHttpStatus(), new Date());
    }
}