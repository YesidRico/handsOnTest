package com.masglobalconsulting.handsOnTest.exceptions.handlers;

import com.masglobalconsulting.handsOnTest.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> notFoundExceptionHandler(NotFoundException e) {
        return new ResponseEntity<>(Response.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }
}
