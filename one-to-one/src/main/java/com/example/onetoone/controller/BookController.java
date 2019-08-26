package com.example.onetoone.controller;


import com.example.onetoone.Repository.BookRepository;
import com.example.onetoone.Repository.LibraryCardRepository;
import com.example.onetoone.exception.BookNotFoundException;
import com.example.onetoone.model.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository bookRepository;
    private final LibraryCardRepository issueRepository;

    public BookController(BookRepository bookRepository, LibraryCardRepository issueRepository) {
        this.bookRepository = bookRepository;
        this.issueRepository = issueRepository;
    }

    @GetMapping("/showBooks")
    public List<Book> showBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity(bookRepository.save(book), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/showBook/{book_id}")
    public Book getBookById(@PathVariable Long book_id) {
//        log.debug("Getting Customers By Id.");
        return bookRepository.findById(book_id).orElseThrow(()-> new BookNotFoundException(book_id));
    }



}