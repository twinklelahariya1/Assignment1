package com.example.onetoone.exception;

public class IssueBookNotFoundException extends IllegalArgumentException {
    private Long issueBookId;

    public IssueBookNotFoundException(Long issueId) {
        this.issueBookId = issueBookId;
    }
}
