package com.tutool.todoapp.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Exception e) {
        super(e);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
