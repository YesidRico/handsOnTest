package com.masglobalconsulting.handsOnTest.exceptions;

public class InternalServerException extends RuntimeException {
    private static final String MESSAGE = "Internal server error";

    public InternalServerException(){
        super(MESSAGE);
    }
}
