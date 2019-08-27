package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.dto.AuthorDto;
import com.finalassignment.bookworm.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    AuthorDto addAuthor(AuthorDto authorDto);
    List<AuthorDto> getAuthor();
    AuthorDto findById(Long authorId);
}
