package com.example.onetoone.controller;


import com.example.onetoone.Repository.IssueBookRepository;
import com.example.onetoone.Repository.LibraryCardRepository;
import com.example.onetoone.Repository.UserRepository;
import com.example.onetoone.exception.UserNotFoundException;
import com.example.onetoone.model.LibraryCard;
import com.example.onetoone.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryCardController {


    private final LibraryCardRepository issueRepository;
    private final UserRepository userRepository;
    private final IssueBookRepository issueBookRepository;

    public LibraryCardController(LibraryCardRepository issueRepository, UserRepository userRepository, IssueBookRepository issueBookRepository) {
        this.issueRepository = issueRepository;
        this.userRepository = userRepository;
        this.issueBookRepository = issueBookRepository;
    }

    @GetMapping("/showIssues")
    public List<LibraryCard> showIssues() {
        return issueRepository.findAll();
    }

    @PostMapping("/issue/{userId}")
    public ResponseEntity<LibraryCard> addIssue(@RequestBody LibraryCard issue, @PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        issue.setUser(user);
        return new ResponseEntity(issueRepository.save(issue), new HttpHeaders(), HttpStatus.OK);
    }
}