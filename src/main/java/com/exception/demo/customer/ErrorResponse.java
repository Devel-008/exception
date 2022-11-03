package com.exception.demo.customer;

public class ErrorResponse {
    private int statusCode;
    private final String message;
    public ErrorResponse(int statusCode, String message){
        super();
        this.statusCode=statusCode;
        this.message = message;
    }
}
