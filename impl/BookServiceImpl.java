package com.gl.hibernate.service.impl;


import com.gl.hibernate.model.Book;
import com.gl.hibernate.repository.BookRepository;
import com.gl.hibernate.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book addBook(Book book) {
        book = bookRepository.save(book);
        return book;
    }

    @Override
    public List<Book> displayBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
