package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.dto.BookInventoryDto;
import com.finalassignment.bookworm.model.BookInventory;

import java.util.List;

public interface BookInventoryService {

    BookInventoryDto addBookInventoryEntry(BookInventoryDto bookInventoryDto);
    List<BookInventoryDto> getBookInventoryDetails();
    BookInventoryDto findById(Long uId);
}
