package com.example.onetoone.controller;


import com.example.onetoone.Repository.BookInventoryRepository;
import com.example.onetoone.Repository.BookRepository;
import com.example.onetoone.Repository.IssueBookRepository;
import com.example.onetoone.Repository.LibraryCardRepository;
import com.example.onetoone.exception.BookNotFoundException;
import com.example.onetoone.exception.LibraryCardNotFoundException;
import com.example.onetoone.model.Book;
import com.example.onetoone.model.IssueBook;
import com.example.onetoone.model.LibraryCard;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IssueBookController {

    private final IssueBookRepository issueBookRepository;
    private final BookRepository bookRepository;
    private final LibraryCardRepository libraryCardRepository ;

    public IssueBookController(IssueBookRepository issueBookRepository, BookInventoryRepository bookInventoryRepository, BookRepository bookRepository, LibraryCardRepository libraryCardRepository) {
        this.issueBookRepository = issueBookRepository;
        this.bookRepository = bookRepository;
        this.libraryCardRepository = libraryCardRepository;
    }

    @GetMapping("/showIssuess")
    public List<IssueBook> showIssuess() {
        return issueBookRepository.findAll();
    }



    @PostMapping("/issueBook/{bookId}/{libraryCardId}")
    public ResponseEntity<IssueBook> addIssueBook(@RequestBody IssueBook issueBook, @PathVariable Long bookId,@PathVariable Long libraryCardId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        issueBook.setBooks(book);

        LibraryCard libraryCard= libraryCardRepository.findById(libraryCardId).orElseThrow(()-> new LibraryCardNotFoundException(libraryCardId));
        issueBook.setLibraryCard(libraryCard);

        return new ResponseEntity(issueBookRepository.save(issueBook), new HttpHeaders(), HttpStatus.OK);
    }
}
