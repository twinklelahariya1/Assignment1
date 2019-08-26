package com.example.onetoone.exception;

public class UserNotFoundException extends IllegalArgumentException {
    private Long userId;

    public UserNotFoundException(Long userId) {
        this.userId = userId;
    }
}

