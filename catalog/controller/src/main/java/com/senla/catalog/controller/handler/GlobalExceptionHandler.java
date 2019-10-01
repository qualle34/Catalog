package com.senla.catalog.controller.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Test exception")
    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentExceptionHandler() {
        logger.error("IllegalArgumentException");
        return "IllegalArgumentException";
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Test exception")
    @ExceptionHandler(RuntimeException.class)
    public String runtimeExceptionHandler() {
        logger.error("RuntimeException");
        return "RuntimeException";
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Test exception")
    @ExceptionHandler(Exception.class)
    public String exceptionHandler() {
        logger.error("Exception");
        return "Exception";
    }
}
