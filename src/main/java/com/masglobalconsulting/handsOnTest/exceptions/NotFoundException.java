package com.masglobalconsulting.handsOnTest.exceptions;

public class NotFoundException extends RuntimeException {
    private static final String MESSAGE = "resource not found";

    public NotFoundException(){
        super(MESSAGE);
    }
}
