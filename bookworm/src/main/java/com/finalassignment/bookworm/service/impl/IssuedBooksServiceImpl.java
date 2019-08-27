package com.finalassignment.bookworm.service.impl;


import com.finalassignment.bookworm.dto.IssuedBooksDto;
import com.finalassignment.bookworm.exception.IssueBookNotFoundException;
import com.finalassignment.bookworm.model.IssuedBooks;
import com.finalassignment.bookworm.repository.IssuedBooksRepository;
import com.finalassignment.bookworm.service.IssuedBooksService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromIssuedBooks;
import static com.finalassignment.bookworm.util.DtoUtil.fromIssuedBooksDto;

@Service
public class IssuedBooksServiceImpl implements IssuedBooksService {


    private final IssuedBooksRepository issuedBooksRepository;

    public IssuedBooksServiceImpl(IssuedBooksRepository issuedBooksRepository) {
        this.issuedBooksRepository = issuedBooksRepository;
    }





    @Override
    public IssuedBooksDto addBooksToCard(IssuedBooksDto issuedBooksDto) {
               IssuedBooks issuedBooks= issuedBooksRepository.save(fromIssuedBooksDto(issuedBooksDto));
                return issuedBooksDto;
    }

    @Override
    public List<IssuedBooksDto> getIssuedBookDetails() {


        List<IssuedBooks> issuedBookss = issuedBooksRepository.findAll();
        List<IssuedBooksDto> issuedBooksDtos = null;
        if (!CollectionUtils.isEmpty(issuedBookss)) {
            issuedBooksDtos = new ArrayList<>();
            for (IssuedBooks issuedBooks : issuedBookss) {
                IssuedBooksDto issuedBooksDto = fromIssuedBooks(issuedBooks);
                issuedBooksDtos.add(issuedBooksDto);
            }
        }
        return issuedBooksDtos;
    }

    @Override
    public IssuedBooksDto findById(Long issueId) {
        IssuedBooks issuedBooks = issuedBooksRepository.findById(issueId).orElseThrow(() -> new IssueBookNotFoundException(issueId));
        IssuedBooksDto issuedBooksDto = fromIssuedBooks(issuedBooks);
        return issuedBooksDto;
    }

    @Override
    public void deleteIssue(Long issueId) {
        issuedBooksRepository.deleteById(issueId);
    }
}
