package com.enum3rat3.studentfeeservice.exception;

public class DomainDoesNotExists extends RuntimeException {
    private String message;
    public DomainDoesNotExists() {}
    public DomainDoesNotExists(String message) {
        super(message);
        this.message = message;
    }
}
