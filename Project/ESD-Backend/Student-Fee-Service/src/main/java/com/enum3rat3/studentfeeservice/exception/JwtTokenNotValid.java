package com.enum3rat3.studentfeeservice.exception;


public class JwtTokenNotValid extends RuntimeException {

    private String message;

    public JwtTokenNotValid(){

    }
    public JwtTokenNotValid(String message) {

        super(message);
        this.message = message;
    }
}