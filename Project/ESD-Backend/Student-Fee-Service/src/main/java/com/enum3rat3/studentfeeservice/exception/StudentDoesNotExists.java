package com.enum3rat3.studentfeeservice.exception;

public class StudentDoesNotExists extends RuntimeException {
    private String message;

    public StudentDoesNotExists() {}
    public StudentDoesNotExists(String message) {

        super(message);
        this.message = message;
    }
}
