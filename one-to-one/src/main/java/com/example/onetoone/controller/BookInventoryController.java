package com.example.onetoone.controller;


import com.example.onetoone.Repository.BookInventoryRepository;
import com.example.onetoone.Repository.BookRepository;
import com.example.onetoone.exception.UserNotFoundException;
import com.example.onetoone.model.Book;
import com.example.onetoone.model.BookInventory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookInventoryController {

    private final BookInventoryRepository bookInventoryRepository;
    private final BookRepository bookRepository;


    public BookInventoryController(BookInventoryRepository bookInventoryRepository,BookRepository bookRepository) {
        this.bookInventoryRepository = bookInventoryRepository;
        this.bookRepository = bookRepository;
    }


    @PostMapping("/{bookId}/inventory")
    public ResponseEntity<BookInventory> addInventory(@RequestBody BookInventory bookInventory, @PathVariable Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new UserNotFoundException(bookId));
        bookInventory.setBook(book);
        return new ResponseEntity(bookInventoryRepository.save(bookInventory), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/inventory")
    public List<BookInventory> showInventory() {
        return bookInventoryRepository.findAll();
    }
}
