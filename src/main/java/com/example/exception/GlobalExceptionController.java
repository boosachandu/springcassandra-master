package com.example.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ExceptionResponse handleProductNotFoundException(ProductNotFoundException exception) {
        String message = exception.getMessage();
        log.error(message);
        return new ExceptionResponse(LocalDateTime.now(), message, HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionResponse handleAllException(Exception exception) {
        String message = exception.getMessage();
        log.error(message);
        return new ExceptionResponse(LocalDateTime.now(), message, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
