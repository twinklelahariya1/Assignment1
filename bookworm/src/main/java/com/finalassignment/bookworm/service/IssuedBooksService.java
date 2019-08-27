package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.dto.IssuedBooksDto;
import com.finalassignment.bookworm.model.IssuedBooks;

import java.util.List;

public interface IssuedBooksService {

    IssuedBooksDto addBooksToCard(IssuedBooksDto issuedBooksDto);
    List<IssuedBooksDto> getIssuedBookDetails();
    IssuedBooksDto findById(Long issueId);
    void deleteIssue(Long issueId);
}
