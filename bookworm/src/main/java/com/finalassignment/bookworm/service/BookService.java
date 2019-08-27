package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto addBook(BookDto bookDto);
    List<BookDto> getBook();
    BookDto findById(Long bookId);
}
