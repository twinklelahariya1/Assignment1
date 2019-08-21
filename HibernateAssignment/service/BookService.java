package com.gl.hibernate.service;

import com.gl.hibernate.model.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);

    List<Book> displayBooks();

    void deleteBook(Long carId);
}