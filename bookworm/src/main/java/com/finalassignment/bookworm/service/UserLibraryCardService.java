package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.dto.UserLibraryCardDto;
import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.model.UserLibraryCard;

import java.util.List;

public interface UserLibraryCardService {

    UserLibraryCardDto addLibraryCardEntry(UserLibraryCardDto userLibraryCardDto);
    List<UserLibraryCardDto> getCardDetails();
    UserLibraryCardDto findById(Long uId);
}
