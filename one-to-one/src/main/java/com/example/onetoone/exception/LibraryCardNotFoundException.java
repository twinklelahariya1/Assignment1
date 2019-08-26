package com.example.onetoone.exception;

public class LibraryCardNotFoundException extends IllegalArgumentException {
    private Long libraryCardId;

    public LibraryCardNotFoundException(Long libraryCardId) {
        this.libraryCardId = libraryCardId;
    }
}
