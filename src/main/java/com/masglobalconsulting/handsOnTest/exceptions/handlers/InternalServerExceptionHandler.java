package com.masglobalconsulting.handsOnTest.exceptions.handlers;

import com.masglobalconsulting.handsOnTest.exceptions.InternalServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InternalServerExceptionHandler {

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<Response> internalServerErrorExceptionHandler(InternalServerException e){
        return new ResponseEntity<>(Response.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
