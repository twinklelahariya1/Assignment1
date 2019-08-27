package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.dto.AuthorDto;
import com.finalassignment.bookworm.exception.AuthorNotFoundException;
import com.finalassignment.bookworm.model.Author;
import com.finalassignment.bookworm.repository.AuthorRepository;
import com.finalassignment.bookworm.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromAuthor;
import static com.finalassignment.bookworm.util.DtoUtil.fromAuthorDto;

@Service
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public AuthorDto addAuthor(AuthorDto authorDto) {
        Author author = authorRepository.save(fromAuthorDto(authorDto));
        return authorDto;
    }

    @Override
    public List<AuthorDto> getAuthor() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> authorDtos = null;
        if (!CollectionUtils.isEmpty(authors)) {
            authorDtos = new ArrayList<>();
            for (Author author : authors) {
                AuthorDto authorDto = fromAuthor(author);
                authorDtos.add(authorDto);
            }
        }
        return authorDtos;
    }

    @Override
    public AuthorDto findById(Long authorId) {

        Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        AuthorDto authorDto = fromAuthor(author);
        return authorDto;
    }


}
