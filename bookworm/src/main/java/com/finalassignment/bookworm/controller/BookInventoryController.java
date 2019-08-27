package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.dto.BookDto;
import com.finalassignment.bookworm.dto.BookInventoryDto;
import com.finalassignment.bookworm.service.impl.BookInventoryServiceImpl;
import com.finalassignment.bookworm.service.impl.BookServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookInventoryController {


    private final BookInventoryServiceImpl bookInventoryService;
    private final BookServiceImpl bookService;

    public BookInventoryController(BookInventoryServiceImpl bookInventoryService, BookServiceImpl bookService) {
        this.bookInventoryService = bookInventoryService;
        this.bookService = bookService;
    }


    @PostMapping("/bookworm/populateInventory/{bookId}")
    public ResponseEntity<BookInventoryDto> populateInventory(@Valid @RequestBody BookInventoryDto bookInventoryDto, @PathVariable Long bookId) {
        BookDto bookDto = bookService.findById(bookId);
        bookInventoryDto.setBook(bookDto);
        return new ResponseEntity(bookInventoryService.addBookInventoryEntry(bookInventoryDto), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/bookworm/showInventory")
    public List<BookInventoryDto> showInventory() {
        return bookInventoryService.getBookInventoryDetails();
    }
}
