package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.dto.*;
import com.finalassignment.bookworm.service.impl.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@RestController
public class IssuedBooksController {

    private final IssuedBooksServiceImpl issuedBooksService;
    private final BookServiceImpl bookService;
    private  final UserLibraryCardServiceImpl userLibraryCardService;
    private final BookInventoryServiceImpl bookInventoryService;
    private final UserServiceImpl userService;

    public IssuedBooksController(IssuedBooksServiceImpl issuedBooksService, BookServiceImpl bookService, UserLibraryCardServiceImpl userLibraryCardService, BookInventoryServiceImpl bookInventoryService, UserServiceImpl userService) {
        this.issuedBooksService = issuedBooksService;
        this.bookService = bookService;
        this.userLibraryCardService = userLibraryCardService;
        this.bookInventoryService = bookInventoryService;
        this.userService = userService;
    }

    @GetMapping("/bookworm/showAllIssuedBooks")
    public ResponseEntity<List> showIssuedBookDetails() {
        return ResponseEntity.ok(issuedBooksService.getIssuedBookDetails());

    }

    @PostMapping("/bookworm/issueBook/{bookId}/{cardId}")
    public ResponseEntity<IssuedBooksDto> issueBook(@Valid @RequestBody IssuedBooksDto issuedBooksDto, @PathVariable Long bookId, @PathVariable Long cardId) {


        BookInventoryDto bookInventoryDto= bookInventoryService.findById(bookId);
        bookInventoryDto.setQuantityOfBooks(bookInventoryDto.getQuantityOfBooks()-1);
        bookInventoryService.addBookInventoryEntry(bookInventoryDto);

        BookDto bookDto = bookService.findById(bookId);
        issuedBooksDto.setBooks(bookDto);

        UserLibraryCardDto userLibraryCardDto= userLibraryCardService.findById(cardId);
        issuedBooksDto.setUserLibraryCard(userLibraryCardDto);

        return new ResponseEntity(issuedBooksService.addBooksToCard(issuedBooksDto), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/bookworm/returnBook/{issueId}")
    public ResponseEntity<Object> returnBook(@PathVariable Long issueId){

        IssuedBooksDto issuedBooksDto=issuedBooksService.findById(issueId);
        BookDto bookDto= issuedBooksDto.getBooks();
        Long bookId=bookDto.getBookId();

        BookInventoryDto bookInventoryDto= bookInventoryService.findById(bookId);
        bookInventoryDto.setQuantityOfBooks(bookInventoryDto.getQuantityOfBooks()+1);
        bookInventoryService.addBookInventoryEntry(bookInventoryDto);

        LocalDate issueDate= issuedBooksDto.getIssueDate();
        LocalDate returnDate = LocalDate.now();

        Period period = Period.between(issueDate,returnDate);
        int difference = period.getDays();

        UserLibraryCardDto userLibraryCardDto=issuedBooksDto.getUserLibraryCard();
        Long cardId=userLibraryCardDto.getCardId();

        UserDto userDto = userService.findById(cardId);

        if(difference > 7){
            int fine = difference*5;
            userDto.setUserTotalFineAmount(userDto.getUserTotalFineAmount()+fine);
        }

        issuedBooksService.deleteIssue(issueId);

        return  ResponseEntity.status(HttpStatus.OK).body("The data is deleted");
    }


}
