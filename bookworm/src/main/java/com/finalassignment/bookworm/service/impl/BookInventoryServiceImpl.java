package com.finalassignment.bookworm.service.impl;


import com.finalassignment.bookworm.dto.BookInventoryDto;
import com.finalassignment.bookworm.exception.BookNotFoundException;
import com.finalassignment.bookworm.model.BookInventory;
import com.finalassignment.bookworm.repository.BookInventoryRepository;
import com.finalassignment.bookworm.service.BookInventoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromBookInventory;
import static com.finalassignment.bookworm.util.DtoUtil.fromBookInventoryDto;

@Service
public class BookInventoryServiceImpl implements BookInventoryService {


    private final BookInventoryRepository bookInventoryRepository;

    public BookInventoryServiceImpl(BookInventoryRepository bookInventoryRepository) {
        this.bookInventoryRepository = bookInventoryRepository;
    }




    @Override
    public BookInventoryDto addBookInventoryEntry(BookInventoryDto bookInventoryDto) {
        BookInventory bookInventory = bookInventoryRepository.save(fromBookInventoryDto(bookInventoryDto));
        return bookInventoryDto;
    }

    @Override
    public List<BookInventoryDto> getBookInventoryDetails() {

        List<BookInventory> bookInventories = bookInventoryRepository.findAll();
        List<BookInventoryDto> bookInventoryDtos = null;
        if (!CollectionUtils.isEmpty(bookInventories)) {
            bookInventoryDtos = new ArrayList<>();
            for (BookInventory bookInventory : bookInventories) {
                BookInventoryDto bookInventoryDto = fromBookInventory(bookInventory);
                bookInventoryDtos.add(bookInventoryDto);
            }
        }
        return bookInventoryDtos;
    }

    @Override
    public BookInventoryDto findById(Long inventoryId) {
        BookInventory bookInventory = bookInventoryRepository.findById(inventoryId).orElseThrow(() -> new BookNotFoundException(inventoryId));
        BookInventoryDto genreDto = fromBookInventory(bookInventory);
        return genreDto;
    }
}