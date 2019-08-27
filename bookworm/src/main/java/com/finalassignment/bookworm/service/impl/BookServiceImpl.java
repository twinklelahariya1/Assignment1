package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.dto.BookDto;
import com.finalassignment.bookworm.exception.BookNotFoundException;
import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.repository.BookRepository;
import com.finalassignment.bookworm.service.AuthorService;
import com.finalassignment.bookworm.service.BookService;
import com.finalassignment.bookworm.service.GenreService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromBook;
import static com.finalassignment.bookworm.util.DtoUtil.fromBookDto;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final GenreService genreService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, GenreService genreService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.genreService = genreService;
    }





    @Override
    public BookDto addBook(BookDto bookDto) {
        bookRepository.save(fromBookDto(bookDto));
        return bookDto;
    }

    @Override
    public List<BookDto> getBook() {

        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = null;
        if (!CollectionUtils.isEmpty(books)) {
            bookDtos = new ArrayList<>();
            for (Book book : books) {
                BookDto bookDto = fromBook(book);
                bookDtos.add(bookDto);
            }
        }
        return bookDtos;
    }

    @Override
    public BookDto findById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        BookDto bookDto = fromBook(book);
        return bookDto;
    }
}
