package com.SpringRESTapis.demo.Controllers;

public class StudentExceptionHandler extends RuntimeException{
    public StudentExceptionHandler(String message) {
        super(message);
    }

    public StudentExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentExceptionHandler(Throwable cause) {
        super(cause);
    }
}
