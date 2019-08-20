package com.gl.hibernate.controller;


import com.gl.hibernate.model.Book;
import com.gl.hibernate.service.impl.BookServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {


    private final BookServiceImpl bookServiceImpl;

    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }


    @GetMapping("/showBook")
    public ResponseEntity<List> displayBooks(){
        return ResponseEntity.ok(bookServiceImpl.displayBooks());
    }


    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book updated = bookServiceImpl.addBook(book);
        return new ResponseEntity(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public HttpStatus deleteBook(@PathVariable("bookId") Long bookId) {
        bookServiceImpl.deleteBook(bookId);
        return HttpStatus.FORBIDDEN;
    }
}
